package pl.uj.edu.values;

import java.util.Objects;

public class DoubleValue extends Value{

    @Override
    public DoubleValue create(String s) {
        DoubleValue v = new DoubleValue();
        v.value = Double.parseDouble(s);
        return v;
    }
    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public DoubleValue add(Value v) {
        DoubleValue result = new DoubleValue();
        if(v.value instanceof Double) {
            result.value = (Double) this.value + (Double) v.value;
        } else if(v.value instanceof Integer) {
            result.value = (Double) this.value + Integer.valueOf(v.value.toString()).doubleValue();
        } else {
            throw new IllegalArgumentException("Cannot add DoubleValue and " + v.value.getClass().getName());
        }
        return result;

    }

    @Override
    public DoubleValue sub(Value v) {
        DoubleValue result = new DoubleValue();
        if(v.value instanceof Double) {
            result.value = (Double) this.value - (Double) v.value;
        } else if(v.value instanceof Integer) {
            result.value = (Double) this.value - Integer.valueOf(v.value.toString()).doubleValue();
        } else {
            throw new IllegalArgumentException("Cannot sub DoubleValue and " + v.value.getClass().getName());
        }
        return result;
    }

    @Override
    public DoubleValue mul(Value v) {
        DoubleValue result = new DoubleValue();
        if(v.value instanceof Double) {
            result.value = (Double) this.value * (Double) v.value;
        } else if(v.value instanceof Integer) {
            result.value = (Double) this.value * Integer.valueOf(v.value.toString()).doubleValue();
        } else {
            throw new IllegalArgumentException("Cannot mul DoubleValue and " + v.value.getClass().getName());
        }
        return result;
    }

    @Override
    public DoubleValue div(Value v) {
        DoubleValue result = new DoubleValue();
        if(v.value instanceof Double) {
            result.value = (Double) this.value / (Double) v.value;
        } else if(v.value instanceof Integer) {
            result.value = (Double) this.value / Integer.valueOf(v.value.toString()).doubleValue();
        } else {
            throw new IllegalArgumentException("Cannot div DoubleValue and " + v.value.getClass().getName());
        }
        return result;
    }

    @Override
    public DoubleValue pow(Value v) {
        DoubleValue result = new DoubleValue();
        if(v.value instanceof Double) {
            result.value = Math.pow((Double) this.value, (Double) v.value);
        } else if(v.value instanceof Integer) {
            result.value = Math.pow((Double) this.value, Integer.valueOf(v.value.toString()).doubleValue());
        } else {
            throw new IllegalArgumentException("Cannot pow DoubleValue and " + v.value.getClass().getName());
        }
        return result;
    }

    @Override
    public boolean eq(Value v) {
        if(v.value instanceof Double) {
            return this.value == v.value;
        } else if(v.value instanceof Integer) {
            return this.value == (Double) Integer.valueOf(v.value.toString()).doubleValue();
        } else {
            throw new IllegalArgumentException("Cannot eq IntegerValue and " + v.value.getClass().getName());
        }
    }

    @Override
    public boolean lte(Value v) {
        if(v.value instanceof Double) {
            return (Double) this.value <= (Double) v.value;
        } else if(v.value instanceof Integer) {
            return (Double) this.value <= (Double) Integer.valueOf(v.value.toString()).doubleValue();
        } else {
            throw new IllegalArgumentException("Cannot lte IntegerValue and " + v.value.getClass().getName());
        }
    }

    @Override
    public boolean gte(Value v) {
        if(v.value instanceof Double) {
            return (Double) this.value >= (Double) v.value;
        } else if(v.value instanceof Integer) {
            return (Double) this.value >= (Double) Integer.valueOf(v.value.toString()).doubleValue();
        } else {
            throw new IllegalArgumentException("Cannot gte IntegerValue and " + v.value.getClass().getName());
        }
    }

    @Override
    public boolean neq(Value v) {
        if(v.value instanceof Double) {
            return this.value != v.value;
        } else if(v.value instanceof Integer) {
            return this.value != (Double) Integer.valueOf(v.value.toString()).doubleValue();
        } else {
            throw new IllegalArgumentException("Cannot neq IntegerValue and " + v.value.getClass().getName());
        }
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof DoubleValue doubleValue) {
            return this.value == doubleValue.value;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
