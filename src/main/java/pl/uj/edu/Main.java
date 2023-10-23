package pl.uj.edu;

import pl.uj.edu.values.IntegerValue;

public class Main {
    public static void main(String[] args) {

        IntegerValue integerValue = new IntegerValue().create("5");
        System.out.println(integerValue.toString());

    }
}
