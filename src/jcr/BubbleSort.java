package jcr;

import java.util.ArrayList;
import java.util.Arrays;

import static jcr.SortingUtils.swapif;

/**
 * Created by quatern10n on 12/20/16.
 * class to handle the bubble sort algorithm
 */
public class BubbleSort {

    private BubbleSort(){}

    /**
     * Uses the bubble sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> bubblesort(ArrayList<T> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                swapif(list, j, j + 1);
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
        for (int i = list.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                swapif(list, j, j + 1);
            }
        }
        return list;
    }

}
