package pl.uj.edu;

import pl.uj.edu.values.DateTimeValue;
import pl.uj.edu.values.DoubleValue;
import pl.uj.edu.values.IntegerValue;
import pl.uj.edu.values.StringValue;

// TODO: Implement Builder pattern for Value class hierarchy
public class Main {
    public static void main(String[] args) {


        System.out.println("Integer tests");
        IntegerValue integerValue = new IntegerValue().create("5");
        DoubleValue doubleValue = new DoubleValue().create("1.5");

        integerValue.print();
        doubleValue.print();

        integerValue.add(doubleValue).print();

        System.out.println("Double tests");
        doubleValue.pow(integerValue).print();

        System.out.println("String tests");
        StringValue stringValue = new StringValue().create("Hello");


        stringValue = stringValue.add(new StringValue().create(", World!"));
        stringValue.print();

        stringValue = stringValue.sub(new StringValue().create("llo"));

        stringValue.print();

        stringValue = stringValue.mul(new IntegerValue().create("5"));

        stringValue.print();

        System.out.println("DateTime tests");

        DateTimeValue dateTimeValue = new DateTimeValue().create("2019-10-10 10:10:10");
        DateTimeValue dateTimeValue2 = new DateTimeValue().create("2019-10-10 10:10:10");

        dateTimeValue.print();
        dateTimeValue2.print();

        System.out.println(dateTimeValue.add(dateTimeValue2));



    }
}
