package pl.uj.edu;

import java.util.ArrayList;

public class Series {

    private final String colName;
    private final String colType;

    private ArrayList<Object> values;
    public Series(String coLName, String colType) {
        this.values = new ArrayList<>();
        this.colName = coLName;
        this.colType = colType;
    }

    public String getColName() {
        return this.colName;
    }

    public String getColType() {
        return this.colType;
    }

    public int size() {
        return values.size();
    }

    public void addValue(Object value) {
        this.values.add(value);
    }

    public ArrayList<Object> getValues() {
        return this.values;
    }

    public void setValues(ArrayList<Object> values) {
        this.values = values;
    }
}
