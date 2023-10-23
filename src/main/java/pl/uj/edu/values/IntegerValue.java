package pl.uj.edu.values;

import java.util.Objects;

public class IntegerValue extends Value{

    @Override
    public IntegerValue create(String s) {
        IntegerValue v = new IntegerValue();
        v.value = Integer.parseInt(s);
        return v;
    }
    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public Value add(Value v) {
        IntegerValue other = (IntegerValue) v;
        IntegerValue result = new IntegerValue();
        result.value = (Integer) this.value + (Integer) other.value;
        return result;
    }
    @Override
    public Value sub(Value v) {
        IntegerValue other = (IntegerValue) v;
        IntegerValue result = new IntegerValue();
        result.value = (Integer) this.value - (Integer) other.value;
        return result;
    }

    @Override
    public Value mul(Value v) {
        IntegerValue other = (IntegerValue) v;
        IntegerValue result = new IntegerValue();
        result.value = (Integer) this.value * (Integer) other.value;
        return result;
    }

    @Override
    public Value div(Value v) {
        IntegerValue other = (IntegerValue) v;
        IntegerValue result = new IntegerValue();
        result.value = (Integer) this.value / (Integer) other.value;
        return result;
    }

    @Override
    public Value pow(Value v) {
        IntegerValue other = (IntegerValue) v;
        IntegerValue result = new IntegerValue();
        result.value = Math.pow((Integer) this.value, (Integer) other.value);
        return result;
    }

    @Override
    public boolean eq(Value v) {
        IntegerValue other = (IntegerValue) v;
        return this.value == other.value;
    }

    @Override
    public boolean lte(Value v) {
        IntegerValue other = (IntegerValue) v;
        return (Integer) this.value <= (Integer) other.value;
    }

    @Override
    public boolean gte(Value v) {
        IntegerValue other = (IntegerValue) v;
        return (Integer) this.value >= (Integer) other.value;
    }

    @Override
    public boolean neq(Value v) {
        IntegerValue other = (IntegerValue) v;
        return this.value != other.value;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof IntegerValue integerValue) {
            return this.value == integerValue.value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
