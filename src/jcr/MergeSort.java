package jcr;

import java.util.ArrayList;
import java.util.Arrays;

import jcr.SortingUtils.SortingOrder;

import static jcr.SortingUtils.swapif;

public class MergeSort {

    private MergeSort() {
    }

    /**
     * merge function that merges two pre-sorted sublists in list
     *
     * @param list the ArrayList which contains the two sublists
     * @param s    the (inclusive) start index of the first sublist
     * @param m    the (inclusive) end index of the first sublist
     *             (m+1) is the (inclusive) start of the second sublist
     * @param e    the (inclusive) end index of the second sublist
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in the list
     * @return the list with the two sorted sublists merged (modifies original list)
     */
    private static <T extends Comparable<T>> ArrayList<T> merge(ArrayList<T> list, int s, int m, int e, SortingOrder so) {
        ArrayList<T> subList1 = new ArrayList<>(list.subList(s, m + 1));
        int s1 = 0;
        int s2 = m + 1;
        int i = s;
        while (s1 < subList1.size() && s2 < e + 1) {
            T elem;
            if (subList1.get(s1).compareTo(list.get(s2)) == so.getValue()) {
                elem = subList1.get(s1++);
            } else {
                elem = list.get(s2++);
            }
            list.set(i++, elem);
        }
        while (s1 < subList1.size()) {
            list.set(i++, subList1.get(s1++));
        }
        return list;
    }

    /**
     * merge function that merges two pre-sorted sublists in list
     *
     * @param list the ArrayList which contains the two sublists
     * @param s    the (inclusive) start index of the first sublist
     * @param m    the (inclusive) end index of the first sublist
     *             (m+1) is the (inclusive) start of the second sublist
     * @param e    the (inclusive) end index of the second sublist
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in the list
     * @return the list with the two sorted sublists merged (modifies original list)
     */
    private static <T extends Comparable<T>> T[] merge(T[] list, int s, int m, int e, SortingOrder so) {
        T[] subList1 = Arrays.copyOfRange(list, s, m+1);
        int s1 = 0;
        int s2 = m + 1;
        int i = s;
        while (s1 < subList1.length && s2 < e + 1) {
            T elem;
            if (subList1[s1].compareTo(list[s2]) == so.getValue()) {
                elem = subList1[s1++];
            } else {
                elem = list[s2++];
            }
            list[i++] = elem;
        }
        while (s1 < subList1.length) {
            list[i++] = subList1[s1++];
        }
        return list;
    }

    /**
     * mergesort method that handles the sorting, uses indexes instead of splitting the ArrayList
     *
     * @param list the ArrayList to sort
     * @param s    the (inclusive) start index of the sublist to mergesort
     * @param e    the (inclusive) end index of the sublist to mergesort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in the list
     * @return the sublist in list sorted (modifies original list)
     */
    private static <T extends Comparable<T>> ArrayList<T> mergesort(ArrayList<T> list, int s, int e, SortingOrder so) {
        if (s == e) {
            return list;
        }
        if (e - s == 1) {
            return swapif(list, s, e, so);
        }
        int m = (e - s) / 2 + s;
        mergesort(list, s, m, so);
        mergesort(list, m + 1, e, so);
        return merge(list, s, m, e, so);
    }

    /**
     * mergesort method that handles the sorting, uses indexes instead of splitting the Array
     *
     * @param list the Array to sort
     * @param s    the (inclusive) start index of the sublist to mergesort
     * @param e    the (inclusive) end index of the sublist to mergesort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in the list
     * @return the sublist in list sorted (modifies original list)
     */
    private static <T extends Comparable<T>> T[] mergesort(T[] list, int s, int e, SortingOrder so) {
        if (s == e) {
            return list;
        }
        if (e - s == 1) {
            return swapif(list, s, e, so);
        }
        int m = (e - s) / 2 + s;
        mergesort(list, s, m, so);
        mergesort(list, m + 1, e, so);
        return merge(list, s, m, e, so);
    }

    /**
     * Uses the merge sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> mergesort(ArrayList<T> list, SortingOrder so) {
        return mergesort(list, 0, list.size() - 1, so);
    }

    /**
     * Uses the merge sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> mergesort(ArrayList<T> list) {
        return mergesort(list, SortingOrder.ASCENDING);
    }

    /**
     * Uses the merge sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] mergesort(T[] list, SortingOrder so) {
        return mergesort(list, 0, list.length - 1, so);
    }

    /**
     * Uses the merge sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] mergesort(T[] list) {
        return mergesort(list, SortingOrder.ASCENDING);
    }

}
