package jcr;

import java.util.ArrayList;
import java.util.Arrays;
import jcr.SortingUtils.SortingOrder;

public class InsertSort {

    private InsertSort(){}

    /**
     * Uses the insert sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> insertsort(ArrayList<T> list, SortingOrder so) {
        for (int i = 1; i < list.size(); i++) {
            T elem = list.get(i);
            int newIndex = i - 1;
            while (newIndex >= 0 && list.get(newIndex).compareTo(elem) == -so.getValue()) {
                list.set(newIndex + 1, list.get(newIndex));
                newIndex--;
            }
            list.set(newIndex + 1, elem);
        }
        return list;
    }

    /**
     * Uses the insert sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> insertsort(ArrayList<T> list) {
        return insertsort(list, SortingOrder.ASCENDING);
    }

    /**
     * Uses the insert sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] insertsort(T[] list, SortingOrder so) {
        for (int i = 1; i < list.length; i++) {
            T elem = list[i];
            int newIndex = i - 1;
            while (newIndex >= 0 && list[newIndex].compareTo(elem) == -so.getValue()) {
                list[newIndex + 1] = list[newIndex];
                newIndex--;
            }
            list[newIndex + 1] = elem;
        }
        return list;
    }

    /**
     * Uses the insert sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] insertsort(T[] list) {
        return insertsort(list, SortingOrder.ASCENDING);
    }
}
