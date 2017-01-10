package jcr;

import java.util.ArrayList;
import jcr.SortingUtils.SortingOrder;

import static jcr.SortingUtils.swapif;

public class BubbleSort {

    private BubbleSort(){}

    /**
     * Uses the bubble sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> bubblesort(ArrayList<T> list, SortingOrder so) {
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                swapif(list, j, j + 1, so);
            }
        }
        return list;
    }

    /**
     * Uses the bubble sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> bubblesort(ArrayList<T> list) {
        return bubblesort(list, SortingOrder.ASCENDING);
    }

    /**
     * Uses the bubble sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] bubblesort(T[] list, SortingOrder so) {
        for (int i = list.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                swapif(list, j, j + 1, so);
            }
        }
        return list;
    }

    /**
     * Uses the bubble sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] bubblesort(T[] list) {
        return bubblesort(list, SortingOrder.ASCENDING);
    }

}
