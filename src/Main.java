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
        int size = 1000000; //35000000 max on my machine for mergesort
        ArrayList<Double> list = new ArrayList<>();
        for (int i=0; i<size; i++){
            list.add(Math.random()*size);
        }
        System.out.println("list generated!");
        boolean sorted = Sorting.isSorted(list);
        System.out.println("list is sorted: " + sorted);
        Sorting.sort(list, SortingType.QUICK);
        System.out.println("list sorted!");
        sorted = Sorting.isSorted(list);
        System.out.println("list is sorted: " + sorted);
    }
}
