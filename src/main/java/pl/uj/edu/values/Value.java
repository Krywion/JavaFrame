package pl.uj.edu.values;

public abstract class Value {

    protected Object value;
    public abstract String toString();
    public abstract void print();
    public abstract Value add(Value v);
    public abstract Value sub(Value v);
    protected abstract Value mul(Value v);
    protected abstract Value div(Value v);
    protected abstract Value pow(Value v);
    protected abstract boolean eq(Value v);
    protected abstract boolean lte(Value v);
    protected abstract boolean gte(Value v);
    protected abstract boolean neq(Value v);
    public abstract boolean equals(Object other);
    public abstract int hashCode();

    public abstract Value create(String s);

}
