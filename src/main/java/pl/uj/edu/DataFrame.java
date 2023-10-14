package pl.uj.edu;


import java.util.ArrayList;

public class DataFrame {

    private final ArrayList<Series> columns;

    public DataFrame(String[] colNames, String[] dtypes) {
        this.columns = new ArrayList<>();
        for(int i = 0; i < colNames.length; i++) {
            this.columns.add(new Series(colNames[i], dtypes[i]));
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
        DataFrame newDataFrame = new DataFrame(new String[]{}, new String[]{});

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


    public void addColumn(String colName, String dtype) {
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
               this.columns.get(i).addValue(row[i]);
           }
           return this;
       }

       // add row to new DataFrame
       else {
           DataFrame df = new DataFrame(new String[]{}, new String[]{});

           // copy columns
           for(Series s : columns) {
               df.addColumn(s.getColName(), s.getColType());
               df.get(s.getColName()).setValues(s.getValues());
           }

           // add row
           for(int i = 0; i < row.length; i++) {
               df.get(columns.get(i).getColName()).addValue(row[i]);
           }
           return df;
       }
    }

    public DataFrame iloc(int i) {
        DataFrame df = new DataFrame(new String[]{}, new String[]{});

        // copy columns
        for(Series s : columns) {
            df.addColumn(s.getColName(), s.getColType());
            df.get(s.getColName()).addValue(s.getValues().get(i));
        }

        return df;
    }

    public void ilocSet(int i, String colName, Object value) {
        this.get(colName).getValues().set(i, value);
    }

    public void printDataFrame() {
        for(Series s : this.columns) {
            System.out.print(s.getColName() + " ");
        }
        System.out.println();
        for(int i = 0; i < this.size(); i++) {
            for(Series s : this.columns) {
                System.out.print("[INDEX] = " + i + ";" +  s.getValues().get(i) + " ");
            }
            System.out.println();
        }
    }
}
