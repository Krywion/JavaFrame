package pl.uj.edu;

import pl.uj.edu.values.COOValue;

import java.io.*;

public class SparseDataFrame extends DataFrame {
    private final Object hide;
    public SparseDataFrame(String[] colNames, String[] dtypes, Object hide) {
        super(colNames, dtypes);
        this.hide = hide;
    }

    public SparseDataFrame(DataFrame df, Object hide) {
        super(df.getColNames(), df.getDtypes());
        this.hide = hide;
        for (int i = 0; i < df.size(); i++) {
            this.addRow(df.getRow(i), true);
        }
    }


    public SparseDataFrame(String fileName, String[] dtypes, Object hide, Object header) throws IOException {
        super(new String[]{}, dtypes);
        this.hide = hide;
        FileInputStream fstream;
        BufferedReader br = null;
        try {
            fstream = new FileInputStream(fileName);
            br = new BufferedReader(new InputStreamReader(fstream));
        } catch (FileNotFoundException e) {
            System.err.println("Error while opening file: " + e.getMessage());
        }

        String strLine;
        if(header == null) {
            strLine = br.readLine();
        } else {
            strLine = (String) header;
        }
        String[] colNames = strLine.split(",");
        for(int i = 0; i < colNames.length; i++) {
            this.columns.add(new Series(colNames[i], dtypes[i]));
        }

        while(true) {
            strLine = br.readLine();
            if (strLine == null) {
                break;
            }
            String[] row = strLine.split(",");
            this.addRow(row, true);
        }
    }

    @Override
    public SparseDataFrame addRow(String[] row, boolean inplace) {

        // check if row length is equal to number of columns
        if(row.length != this.columns.size()) {
            throw new IllegalArgumentException("Row length must be equal to number of columns");
        }
        int index = this.size();
        // add row to this SprarseDataFrame
        if(inplace) {

            for(int i = 0; i < row.length; i++) {
                if(!row[i].equals(hide)) {
                    this.columns.get(i).addValue(new COOValue(row[i], index-i));
                } else {
                    this.columns.get(i).addValue("");
                }
                index++;

            }
            return this;
        }

        // add row to new SprarseDataFrame
        else {
            SparseDataFrame sdf = new SparseDataFrame(new String[]{}, new String[]{}, this.hide);

            // copy columns
            for(Series s : columns) {
                sdf.addColumn(s.getColName(), s.getColType());
                sdf.get(s.getColName()).setValues(s.getValues());
            }

            // add row
            for(int i = 0; i < row.length; i++) {
                if(!row[i].equals(hide)) {
                    sdf.get(columns.get(i).getColName()).addValue(new COOValue(row[i], i));
                }
            }
            return sdf;
        }
    }

    public DataFrame toDense() {
        DataFrame df = new DataFrame(this.getColNames(), this.getDtypes());
        for(int i = 0; i < this.size(); i++) {
            String[] row = new String[this.columns.size()];
            for(int j = 0; j < this.columns.size(); j++) {
                try {
                    row[j] = this.columns.get(j).getValues().get(i).toString();
                } catch (IndexOutOfBoundsException e) {
                    row[j] = "";
                }
            }
            df.addRow(row, true);
        }
        return df;
    }




}
