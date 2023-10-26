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
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public IntegerValue add(Value v) {
        IntegerValue result = new IntegerValue();
        if(v.value instanceof Integer) {
            result.value = (Integer) this.value + (Integer) v.value;
        } else if(v.value instanceof Double) {
            result.value = (Integer) this.value + Double.valueOf(v.value.toString()).intValue();
        } else {
            throw new IllegalArgumentException("Cannot add IntegerValue and " + v.value.getClass().getName());
        }
        return result;
    }
    @Override
    public IntegerValue sub(Value v) {
        IntegerValue result = new IntegerValue();
        if(v.value instanceof Integer) {
            result.value = (Integer) this.value - (Integer) v.value;
        } else if(v.value instanceof Double) {
            result.value = (Integer) this.value - Double.valueOf(v.value.toString()).intValue();
        } else {
            throw new IllegalArgumentException("Cannot sub IntegerValue and " + v.value.getClass().getName());
        }
        return result;
    }

    @Override
    public IntegerValue mul(Value v) {
        IntegerValue result = new IntegerValue();
        if(v.value instanceof Integer) {
            result.value = (Integer) this.value * (Integer) v.value;
        } else if(v.value instanceof Double) {
            result.value = (Integer) this.value * Double.valueOf(v.value.toString()).intValue();
        } else {
            throw new IllegalArgumentException("Cannot mul IntegerValue and " + v.value.getClass().getName());
        }
        return result;
    }

    @Override
    public IntegerValue div(Value v) {
        IntegerValue result = new IntegerValue();
        if(v.value instanceof Integer) {
            result.value = (Integer) this.value / (Integer) v.value;
        } else if(v.value instanceof Double) {
            result.value = (Integer) this.value / Double.valueOf(v.value.toString()).intValue();
        } else {
            throw new IllegalArgumentException("Cannot div IntegerValue and " + v.value.getClass().getName());
        }
        return result;
    }

    @Override
    public IntegerValue pow(Value v) {
        IntegerValue result = new IntegerValue();
        if(v.value instanceof Integer) {
            result.value = Math.pow((Integer) this.value, (Integer) v.value);
        } else if(v.value instanceof Double) {
            result.value = Math.pow((Integer) this.value, Double.valueOf(v.value.toString()).intValue());
        } else {
            throw new IllegalArgumentException("Cannot pow IntegerValue and " + v.value.getClass().getName());
        }
        return result;
    }

    @Override
    public boolean eq(Value v) {
        if(v.value instanceof Integer) {
            return this.value.equals(v.value);
        } else if(v.value instanceof Double) {
            return this.value.equals(Double.valueOf(v.value.toString()).intValue());
        } else {
            throw new IllegalArgumentException("Cannot eq IntegerValue and " + v.value.getClass().getName());
        }
    }

    @Override
    public boolean lte(Value v) {
        if(v.value instanceof Integer) {
            return (Integer) this.value <= (Integer) v.value;
        } else if(v.value instanceof Double) {
            return (Integer) this.value <= (Integer) Double.valueOf(v.value.toString()).intValue();
        } else {
            throw new IllegalArgumentException("Cannot lte IntegerValue and " + v.value.getClass().getName());
        }
    }

    @Override
    public boolean gte(Value v) {
        if(v.value instanceof Integer) {
            return (Integer) this.value >= (Integer) v.value;
        } else if(v.value instanceof Double) {
            return (Integer) this.value >= (Integer) Double.valueOf(v.value.toString()).intValue();
        } else {
            throw new IllegalArgumentException("Cannot gte IntegerValue and " + v.value.getClass().getName());
        }
    }

    @Override
    public boolean neq(Value v) {
        if(v.value instanceof Integer) {
            return this.value != v.value;
        } else if(v.value instanceof Double) {
            return this.value != (Integer) Double.valueOf(v.value.toString()).intValue();
        } else {
            throw new IllegalArgumentException("Cannot neq IntegerValue and " + v.value.getClass().getName());
        }
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
