package pl.uj.edu.values;

public final class COOValue extends Value{

    private final int index;

    public COOValue(Object value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public COOValue create(String s) {
        return null;
    }

    public Object getValue() {
        return this.value;
    }

    public int getMyIndex() {
        return this.index;
    }

    public String toString() {
        return this.value.toString();
    }

    @Override
    public Value add(Value v) {
        return null;
    }

    @Override
    public Value sub(Value v) {
        return null;
    }

    @Override
    public Value mul(Value v) {
        return null;
    }

    @Override
    public Value div(Value v) {
        return null;
    }

    @Override
    public Value pow(Value v) {
        return null;
    }

    @Override
    public boolean eq(Value v) {
        return false;
    }

    @Override
    public boolean lte(Value v) {
        return false;
    }

    @Override
    public boolean gte(Value v) {
        return false;
    }

    @Override
    public boolean neq(Value v) {
        return false;
    }

    @Override
    public boolean equals(Object other) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
