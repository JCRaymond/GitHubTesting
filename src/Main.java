import java.util.ArrayList;
import jcr.Sorting;
import jcr.Sorting.SortingType;
import java.util.Arrays;

/**
 * Created by Jacob on 12/14/2016.
 * Main class with test cases, no particular functionality
 */
public class Main {

    public static void main(String[] args) {
        int size = 20000000;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * size));
        }
//        ArrayList<Integer> olist = (ArrayList<Integer>)(list.clone());
        System.out.println("List is sorted?");
        System.out.println(Sorting.isSorted(list));
        System.out.print("Sorting... ");
        long s = System.currentTimeMillis();
        Sorting.sort(list, SortingType.HEAP);
        long e = System.currentTimeMillis();
        System.out.println("(Took " + (e - s) / 1000. + " seconds)");
        System.out.println("List is sorted?");
        System.out.println(Sorting.isSorted(list));
//        System.out.println("List contains the same values?");
//        System.out.println(Sorting.containsSameVals(olist, list));

    }
}
