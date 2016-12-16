import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 12/14/2016.
 * Class with a variety of sorting algorithms, cannot be instantiated
 */
public class Sorting {

    private Sorting() {
    }

    //region Bubble Sort

    /**
     * Uses the bubble sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     */
    public static <T extends Comparable<T>> void bubblesort(ArrayList<T> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) == 1) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Uses the bubble sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void bubblesort(T[] list) {
        if (list.length == 0) {
            return;
        }
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(list));
        bubblesort(arrayList);
        arrayList.toArray(list);
    }

    //endregion

    //region Insert Sort

    /**
     * Uses the insert sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     */
    public static <T extends Comparable<T>> void insertsort(ArrayList<T> list) {
        for (int i = 1; i < list.size(); i++){
            int newIndex = i-1;
            while (list.get(newIndex).compareTo(list.get(i)) == 1 && newIndex>=0){
                newIndex--;
            }
            T elem = list.get(i);
            for (int j = i-1; j>newIndex; j--){
                list.set(j+1, list.get(j));
            }
            list.set(newIndex, elem);
            System.out.println(list);
        }
    }
    //endregion

}
