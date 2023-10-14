package pl.uj.edu;


public class Main {
    public static void main(String[] args) {
        // create new DataFrame
        DataFrame df = new DataFrame(new String[]{"kol1", "kol2"}, new String[]{"int", "double"});
        df.addRow(new String[]{"1", "2.0"}, true);
        df.addRow(new String[]{"1", "2.0"}, true);

        DataFrame shallowCopy = df.get(new String[]{"kol1"}, false);
        DataFrame deepCopy = df.get(new String[]{"kol1"}, true);

        // change value in original DataFrame
        df.ilocSet(0, "kol1", 2);

        // print shallow copy
        shallowCopy.printDataFrame();

        // print deep copy
        deepCopy.printDataFrame();





    }
}
