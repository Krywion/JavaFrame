package pl.uj.edu.values;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

// TODO: Refactor the add, sub methods;
public class DateTimeValue extends Value {
    private LocalDateTime value;

    @Override
    public DateTimeValue create(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parsedDateTime = LocalDateTime.parse(s, formatter);
        DateTimeValue dateTimeValue = new DateTimeValue();
        dateTimeValue.value = parsedDateTime;
        return dateTimeValue;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return value.format(formatter);
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public DateTimeValue add(Value other) {
        if (other instanceof DateTimeValue) {
            LocalDateTime result = this.value.plusSeconds(((DateTimeValue) other).value.getSecond());
            DateTimeValue dateTimeValue = new DateTimeValue();
            dateTimeValue.value = result;
            return dateTimeValue;
        } else {
            throw new IllegalArgumentException("Cannot add DateTimeValue and " + other.getClass().getName());
        }
    }

    @Override
    public DateTimeValue sub(Value other) {
        if (other instanceof DateTimeValue) {
            LocalDateTime result = this.value.minusSeconds(((DateTimeValue) other).value.getSecond());
            DateTimeValue dateTimeValue = new DateTimeValue();
            dateTimeValue.value = result;
            return dateTimeValue;
        } else {
            throw new IllegalArgumentException("Cannot sub DateTimeValue and " + other.getClass().getName());
        }
    }

    @Override
    protected Value mul(Value v) {
        // DateTimeValue mul doesn't make sense, so we return null
        return null;
    }

    @Override
    protected Value div(Value v) {
        // DateTimeValue div doesn't make sense, so we return null
        return null;
    }

    protected Value pow(Value v) {
        // DateTimeValue pow doesn't make sense, so we return null
        return null;
    }

    @Override
    public boolean eq(Value other) {
        if (other instanceof DateTimeValue) {
            return this.value.equals(((DateTimeValue) other).value);
        } else {
            throw new IllegalArgumentException("Cannot compare DateTimeValue and " + other.getClass().getName());
        }
    }

    @Override
    public boolean lte(Value other) {
        if (other instanceof DateTimeValue) {
            return this.value.isBefore(((DateTimeValue) other).value) || this.value.equals(((DateTimeValue) other).value);
        } else {
            throw new IllegalArgumentException("Cannot compare DateTimeValue and " + other.getClass().getName());
        }
    }

    @Override
    public boolean gte(Value other) {
        if (other instanceof DateTimeValue) {
            return this.value.isAfter(((DateTimeValue) other).value) || this.value.equals(((DateTimeValue) other).value);
        } else {
            throw new IllegalArgumentException("Cannot compare DateTimeValue and " + other.getClass().getName());
        }
    }

    @Override
    public boolean neq(Value other) {
        return !eq(other);
    }

    @Override
    public boolean equals(Object other) {
        return this == other;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
