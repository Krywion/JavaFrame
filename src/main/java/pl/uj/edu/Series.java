package pl.uj.edu;

import pl.uj.edu.values.Value;

import java.util.ArrayList;

public class Series {

    private final String colName;
    private final Class<? extends Value> colType;

    private ArrayList<Value> values;
    public Series(String coLName, Class colType) {
        this.values = new ArrayList<>();
        this.colName = coLName;
        this.colType = colType;
    }

    public String getColName() {
        return this.colName;
    }

    public Class<? extends Value> getColType() {
        return this.colType;
    }

    public int size() {
        return values.size();
    }

    public void addValue(Value value) {
        this.values.add(value);
    }

    public ArrayList<Value> getValues() {
        return this.values;
    }

    public void setValues(ArrayList<Value> values) {
        this.values = values;
    }
}
