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
        int size = 50000000;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<size; i++){
            list.add((int) (Math.random()*size));
        }
        System.out.println("List is sorted?");
        System.out.println(Sorting.isSorted(list));
        System.out.print("Sorting... ");
        long s = System.currentTimeMillis();
        Sorting.sort(list, SortingType.QUICK);
        long e = System.currentTimeMillis();
        System.out.println("(Took " + (e-s)/1000. + " seconds)");
        System.out.println("List is sorted?");
        System.out.println(Sorting.isSorted(list));
    }
}
