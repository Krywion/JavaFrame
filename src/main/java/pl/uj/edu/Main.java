package pl.uj.edu;


public class Main {
    public static void main(String[] args) {
        // create new DataFrame
        DataFrame df = new DataFrame(new String[]{"kol1", "kol2"}, new String[]{"int", "double"});
        df.addRow(new String[]{"1", "2.0"}, true);
        df.addRow(new String[]{"1", "2.0"}, true);

        // print DataFrame
        df.printDataFrame();

        DataFrame shallowCopy = df.get(new String[]{"kol1"}, false);
        DataFrame deepCopy = df.get(new String[]{"kol1"}, true);

        // change value in original DataFrame
        df.ilocSet(0, "kol1", 2);
        df.addRow(new String[]{"1", "2.0"}, true);

        // print shallow copy
        System.out.println("Shallow copy:");
        shallowCopy.printDataFrame();

        // print deep copy
        System.out.println("Deep copy:");
        deepCopy.printDataFrame();

        // print original DataFrame
        df.printDataFrame();


    }
}
