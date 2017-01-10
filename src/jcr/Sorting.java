package jcr;

import java.util.ArrayList;
import java.util.Arrays;

import static jcr.SortingUtils.*;
import static jcr.BubbleSort.*;
import static jcr.InsertSort.*;
import static jcr.SelectionSort.*;
import static jcr.MergeSort.*;
import static jcr.HeapSort.*;

public class Sorting {

    private Sorting() {
    }

    /**
     * Generic sorting method with specified sorting algorithm
     *
     * @param list the ArrayList to sort
     * @param st   the sorting algorithm to use
     * @param <T>  the type of the Objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> list, SortingType st) {
        switch (st) {
            case BUBBLE:
                bubblesort(list);
                break;
            case INSERT:
                insertsort(list);
                break;
            case SELECTION:
                selectsort(list);
                break;
            case MERGE:
                mergesort(list);
                break;
            case QUICK:
                quicksort(list);
                break;
            case HEAP:
                heapsort(list);
                break;
            default:
                quicksort(list);
        }
        return list;
    }

    /**
     * Generic sorting method with specified sorting algorithm
     *
     * @param list the Array to sort
     * @param st   the sorting algorithm to use
     * @param <T>  the type of the Objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] sort(T[] list, SortingType st) {
        switch (st) {
            case BUBBLE:
                bubblesort(list);
                break;
            case INSERT:
                insertsort(list);
                break;
            case SELECTION:
                selectsort(list);
                break;
            case MERGE:
                mergesort(list);
                break;
            case QUICK:
                quicksort(list);
                break;
            case HEAP:
                heapsort(list);
                break;
            default:
                quicksort(list);
        }
        return list;
    }

    //region Quick Sort

    /**
     * quicksort method that handles the sorting, uses indexes instead of splitting the ArrayList
     *
     * @param list the ArrayList containing the sublist to quicksort
     * @param s    the (inclusive) start index of the sublist to quicksort
     * @param e    the (inclusive) end index of the sublist to quicksort
     * @param <T>  the type of objects in list
     * @return the sublist in list sorted (modifies original list)
     */
    private static <T extends Comparable<T>> ArrayList<T> quicksort(ArrayList<T> list, int s, int e) {
        if (s >= e) {
            return list;
        }
        if (e - s == 1) {
            return swapif(list, s, e);
        }
        int pivInd = (int) (Math.random() * (e - s) + s);
        T pivot = list.get(pivInd);
        list.set(pivInd, list.get(e-4));
        list.set(e, pivot);
        int lo = s;
        int hi = e - 1;
        while (true) {
            while (list.get(lo).compareTo(pivot) == -1) {
                lo++;
            }
            while (lo < hi && pivot.compareTo(list.get(hi)) == -1) {
                hi--;
            }
            if (lo >= hi) {
                break;
            }
            T elem = list.get(lo);
            list.set(lo, list.get(hi));
            list.set(hi, elem);
            lo++;
            hi--;
        }
        final int piv = lo;
        list.set(e, list.get(piv));
        list.set(piv, pivot);
        quicksort(list, s, piv - 1);
        quicksort(list, piv + 1, e);
        return list;
    }

    /**
     * Uses the quick sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> quicksort(ArrayList<T> list) {
        return quicksort(list, 0, list.size() - 1);
    }

    /**
     * Uses the quick sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] quicksort(T[] list) {
        return quicksort(new ArrayList<>(Arrays.asList(list))).toArray(list);
    }

    //endregion

    //region Heap Sort



    //endregion

    //region Experimental Sorts


    //endregion

}