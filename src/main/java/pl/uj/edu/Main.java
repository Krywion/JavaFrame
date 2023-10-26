package pl.uj.edu;

import pl.uj.edu.values.*;

import java.io.IOException;

// TODO: Implement Builder pattern for Value class hierarchy
// TODO: Make Tests for DataFrame class and SparseDataFrame class
public class Main {
    public static void main(String[] args) throws IOException {
        /*
        System.out.println("Dataframe tests");
        DataFrame df = new DataFrame("/Users/makskrywionek/Documents/ProjektyIntelliJ/JavaFrame/src/main/java/pl/uj/edu/data.csv", new Class[]{DoubleValue.class, DoubleValue.class, DoubleValue.class}, null);
        df.printDataFrame();
    */
        SparseDataFrame sdf = new SparseDataFrame("/Users/makskrywionek/Documents/ProjektyIntelliJ/JavaFrame/src/main/java/pl/uj/edu/sparse.csv",
                new Class[]{DoubleValue.class, DoubleValue.class, DoubleValue.class},
                new DoubleValue().create("0.0"),
                null);
        sdf.printDataFrame();

        /*
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
        DateTimeValue dateTimeValue2 = new DateTimeValue().create("2019-10-10 10:20:10");
        DateTimeValue dateTimeValue3= new DateTimeValue().create("2019-10-10 10:20:10");

        dateTimeValue.print();
        dateTimeValue2.print();

        System.out.println(dateTimeValue.gte(dateTimeValue2));
        */



    }
}
