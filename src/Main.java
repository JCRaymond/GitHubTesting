import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 12/14/2016.
 * Main class with test cases, no particular functionality
 */
public class Main {

    public static void main(String[] args) {
        int size = 100000000;
        ArrayList<Double> list = new ArrayList<>();
        for (int i=0; i<size; i++){
            list.add(Math.random()*size);
        }
        System.out.println(Sorting.isSorted(list));
        Sorting.mergesort(list);
        System.out.println(Sorting.isSorted(list));
    }
}
