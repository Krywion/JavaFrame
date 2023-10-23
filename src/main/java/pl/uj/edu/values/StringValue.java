package pl.uj.edu.values;

import java.util.Objects;

public class StringValue extends Value{

    @Override
    public StringValue create(String s) {
        StringValue v = new StringValue();
        v.value = s;
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
    public StringValue add(Value v) {
        StringValue result = new StringValue();
        if(v.value instanceof String) {
            result.value = this.value + (String) v.value;
        } else if (v.value instanceof Integer) {
            result.value = this.value + v.value.toString();
        } else if(v.value instanceof Double) {
            result.value = this.value + v.value.toString();
        }
        else {
            throw new IllegalArgumentException("Cannot add StringValue and " + v.value.getClass().getName());
        }
        return result;
    }

    @Override
    public StringValue sub(Value v) {
        StringValue result = new StringValue();
        if(v.value instanceof String) {
            result.value = this.value.toString().replace(v.value.toString(), "");
        } else {
            throw new IllegalArgumentException("Cannot sub StringValue and " + v.value.getClass().getName());
        }
        return result;
    }

    @Override
    public StringValue mul(Value v) {
        StringValue result = new StringValue();
        if(v.value instanceof Integer) {
            result.value = this.value.toString().repeat((Integer) v.value);
        } else if (v.value instanceof Double) {
            result.value = this.value.toString().repeat(Double.valueOf(v.value.toString()).intValue());
        } else {
            throw new IllegalArgumentException("Cannot mul StringValue and " + v.value.getClass().getName());
        }
        return result;
    }

    @Override
    protected StringValue div(Value v) {
        // StringValue div doesn't make sense for string, so we return null
        return null;
    }

    @Override
    public Value pow(Value v) {
        // StringValue pow doesn't make sense for string, so we return null
        return null;
    }

    @Override
    public boolean eq(Value v) {
        if (v.value instanceof String) {
            return this.value.equals(v.value);
        } else {
            return false;
        }
    }

    @Override
    public boolean lte(Value v) {
        if(v.value instanceof String) {
            return this.value.toString().length() <= v.value.toString().length();
        } else {
            throw new IllegalArgumentException("Cannot lte StringValue and " + v.value.getClass().getName());
        }
    }

    @Override
    public boolean gte(Value v) {
        if(v.value instanceof String) {
            return this.value.toString().length() >= v.value.toString().length();
        } else {
            throw new IllegalArgumentException("Cannot gte StringValue and " + v.value.getClass().getName());
        }
    }

    @Override
    public boolean neq(Value v) {
        if (v.value instanceof String) {
            return !this.value.equals(v.value);
        } else {
            return true;
        }
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof StringValue) {
            return this.value.toString().equals(other.toString());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
