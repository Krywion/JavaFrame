package pl.uj.edu;


import pl.uj.edu.values.IntegerValue;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        IntegerValue integerValue = new IntegerValue().create("5");
        System.out.println(integerValue.toString());

    }
}
