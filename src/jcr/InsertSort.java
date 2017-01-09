package jcr;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by quatern10n on 12/20/16.
 */
public class InsertSort {

    private InsertSort(){}

    /**
     * Uses the insert sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> insertsort(ArrayList<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T elem = list.get(i);
            int newIndex = i - 1;
            while (newIndex >= 0 && list.get(newIndex).compareTo(elem) == 1) {
                list.set(newIndex + 1, list.get(newIndex));
                newIndex--;
            }
            list.set(newIndex + 1, elem);
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
        return insertsort(new ArrayList<>(Arrays.asList(list))).toArray(list);
    }

}
