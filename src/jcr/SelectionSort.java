package jcr;

import java.util.ArrayList;
import jcr.SortingUtils.SortingOrder;

public class SelectionSort {

    private SelectionSort(){}

    /**
     * Uses the selection sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> selectsort(ArrayList<T> list, SortingOrder so) {
        for (int i = 0; i < list.size() - 1; i++) {
            int lowestPos = i;
            T lowestElem = list.get(lowestPos);
            for (int j = i + 1; j < list.size(); j++) {
                if (lowestElem.compareTo(list.get(j)) == -so.getValue()) {
                    lowestPos = j;
                    lowestElem = list.get(lowestPos);
                }
            }
            list.set(lowestPos, list.get(i));
            list.set(i, lowestElem);
        }
        return list;
    }

    /**
     * Uses the selection sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> selectsort(ArrayList<T> list) {
        return selectsort(list, SortingOrder.ASCENDING);
    }

    /**
     * Uses the selection sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] selectsort(T[] list, SortingOrder so) {
        for (int i = 0; i < list.length - 1; i++) {
            int lowestPos = i;
            T lowestElem = list[lowestPos];
            for (int j = i + 1; j < list.length; j++) {
                if (lowestElem.compareTo(list[j]) == -so.getValue()) {
                    lowestPos = j;
                    lowestElem = list[lowestPos];
                }
            }
            list[lowestPos] = list[i];
            list[i] = lowestElem;
        }
        return list;
    }

    /**
     * Uses the selection sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] selectsort(T[] list) {
        return selectsort(list, SortingOrder.ASCENDING);
    }
}
