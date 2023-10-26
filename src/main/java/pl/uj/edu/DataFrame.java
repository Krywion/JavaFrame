package pl.uj.edu;


import pl.uj.edu.values.Value;

import java.io.*;
import java.util.ArrayList;

public class DataFrame {

    protected ArrayList<Series> columns;

    public DataFrame(String[] colNames, Class<? extends Value>[] dtypes) {
        this.columns = new ArrayList<>();
        for(int i = 0; i < colNames.length; i++) {
            this.columns.add(new Series(colNames[i], dtypes[i]));
        }
    }

    public DataFrame(String fileName, Class<? extends Value>[] dtypes, Object header) throws IOException {
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
        this.columns = new ArrayList<>();
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

    public int size() {
        return this.columns.get(0).size();
    }

    public Series get(String colName) {
        for(Series s : this.columns) {
            if(s.getColName().equals(colName)) {
                return s;
            }
        }
        return null;
    }

    public DataFrame get(String[] cols, boolean copy) {
        // new DataFrame
        DataFrame newDataFrame = new DataFrame(new String[]{}, new Class[]{});

        // copy columns
        for (String col : cols) {
            Series selectedSeries = this.get(col);
            if (selectedSeries != null) {
                newDataFrame.addColumn(selectedSeries.getColName(), selectedSeries.getColType());
                if (copy) {
                    // deep copy - copy values to new ArrayList
                    newDataFrame.get(col).setValues(new ArrayList<>(selectedSeries.getValues()));
                } else {
                    // shallow copy - copy reference to the same ArrayList
                    newDataFrame.get(col).setValues(selectedSeries.getValues());
                }
            }
        }

        return newDataFrame;
    }


    public void addColumn(String colName, Class<? extends Value> dtype) {
        this.columns.add(new Series(colName, dtype));
    }

    // inplace - if true, then add row to this DataFrame, if false, then create new DataFrame
    public DataFrame addRow(String[] row, boolean inplace) {

        // check if row length is equal to number of columns
        if(row.length != this.columns.size()) {
            throw new IllegalArgumentException("Row length must be equal to number of columns");
        }

       // add row to this DataFrame
       if(inplace) {
           for(int i = 0; i < row.length; i++) {
               Value v = null;
               try {
                   v = this.columns.get(i).getColType().newInstance().create(row[i]);
               } catch (InstantiationException | IllegalAccessException e) {
                   e.printStackTrace();
               }
               this.columns.get(i).addValue(v);
           }
           return this;
       }

       // add row to new DataFrame
       else {
           DataFrame df = new DataFrame(new String[]{}, new Class[]{});

           // copy columns
           for(Series s : columns) {
               df.addColumn(s.getColName(), s.getColType());
               df.get(s.getColName()).setValues(s.getValues());
           }

           // add row
           for(int i = 0; i < row.length; i++) {
               Value v = null;
                try {
                     v = this.columns.get(i).getColType().newInstance().create(row[i]);
                } catch (InstantiationException | IllegalAccessException e) {
                     e.printStackTrace();
                }
               df.get(columns.get(i).getColName()).addValue(v);
           }
           return df;
       }
    }

    public DataFrame iloc(int i) {
        DataFrame df = new DataFrame(new String[]{}, new Class[]{});

        // copy columns
        for(Series s : columns) {
            df.addColumn(s.getColName(), s.getColType());
            df.get(s.getColName()).addValue(s.getValues().get(i));
        }

        return df;
    }

    public void ilocSet(int i, String colName, Value value) {
        this.get(colName).getValues().set(i, value);
    }

    public DataFrame iloc(int from, int to) {
        DataFrame df = new DataFrame(new String[]{}, new Class[]{});

        // copy columns
        for(Series s : columns) {
            df.addColumn(s.getColName(), s.getColType());
            for(int i = from; i < to; i++) {
                df.get(s.getColName()).addValue(s.getValues().get(i));
            }
        }

        return df;
    }

    public void printDataFrame() {
        for(Series s : this.columns) {
            System.out.print(s.getColName() + " ");
        }
        System.out.println();
        for(int i = 0; i < this.size(); i++) {
            System.out.print("[INDEX = " + i + "] = ");
            for(Series s : this.columns) {
                try {
                    System.out.print(s.getValues().get(i) + " ");
                } catch (Exception IndexOutOfBoundsException) {
                    System.out.print("");
                }
            }
            System.out.println();
        }
    }


    protected String[] getColNames() {
        String[] colNames = new String[this.columns.size()];
        for(int i = 0; i < this.columns.size(); i++) {
            colNames[i] = this.columns.get(i).getColName();
        }
        return colNames;
    }

    protected Class<? extends Value>[] getDtypes() {
        Class<? extends Value>[] dtypes = (Class<? extends Value>[]) new Class<?>[this.columns.size()];
        for(int i = 0; i < this.columns.size(); i++) {
            dtypes[i] = this.columns.get(i).getColType();
        }
        return dtypes;
    }

    protected String[] getRow(int i) {
        String[] row = new String[this.columns.size()];
        for(int j = 0; j < this.columns.size(); j++) {
            row[j] = this.columns.get(j).getValues().get(i).toString();
        }
        return row;
    }
}
