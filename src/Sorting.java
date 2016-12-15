import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 12/14/2016.
 * Class with a variety of sorting algorithms, cannot be instantiated
 */
public class Sorting {

    private Sorting(){}

    /**
     * Uses the bubble sort algorithm to sort a generic ArrayList
     * @param list the ArrayList to sort
     * @param <T> the type of the objects in list
     */
    public static <T extends Comparable<T>> void bubblesort(ArrayList<T> list){
        for (int i = list.size()-1; i>=0; i--){
            for (int j=0; j<i; j++){
                if ( list.get(j).compareTo( list.get(j+1)) == 1){
                    T temp =  list.get(j);
                     list.set(j,  list.get(j+1));
                     list.set(j+1, temp);
                }
            }
        }
    }

    /**
     * Uses the bubble sort algorithm to sort a generic Array
     * @param list the Array to sort
     * @param <T> the type of the objects in list
     * @return the sort list
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void bubblesort(T[] list){
        if (list.length == 0){
            return;
        }
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(list));
        bubblesort(arrayList);
        arrayList.toArray(list);
    }
}
