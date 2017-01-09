package jcr;

import java.util.ArrayList;
import java.util.Arrays;

import static jcr.SortingUtils.*;
import static jcr.BubbleSort.*;
import static jcr.InsertSort.*;

/**
 * Created by Jacob on 12/14/2016.
 * Class with a variety of sorting algorithms, cannot be instantiated
 */
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


    //region Selection Sort

    /**
     * Uses the selection sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> selectsort(ArrayList<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int lowestPos = i;
            T lowestElem = list.get(lowestPos);
            for (int j = i + 1; j < list.size(); j++) {
                if (lowestElem.compareTo(list.get(j)) == 1) {
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
     * Uses the selection sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] selectsort(T[] list) {
        return selectsort(new ArrayList<>(Arrays.asList(list))).toArray(list);
    }

    //endregion

    //region Merge Sort

    /**
     * merge function that merges two pre-sorted sublists in list
     *
     * @param list the ArrayList which contains the two sublists
     * @param s    the (inclusive) start index of the first sublist
     * @param m    the (inclusive) end index of the first sublist
     *             (m+1) is the (inclusive) start of the second sublist
     * @param e    the (inclusive) end index of the second sublist
     * @param <T>  the type of the objects in the list
     * @return the list with the two sorted sublists merged (modifies original list)
     * @deprecated use {@link #merge(ArrayList, int, int, int)}  instead, it is more space and time efficient
     */
    @Deprecated
    private static <T extends Comparable<T>> ArrayList<T> oldmerge(ArrayList<T> list, int s, int m, int e) {
        ArrayList<T> subList1 = new ArrayList<>(list.subList(s, m + 1));
        ArrayList<T> subList2 = new ArrayList<>(list.subList(m + 1, e + 1));
        int s1 = 0;
        int s2 = 0;
        int i = s;
        while (s1 < subList1.size() && s2 < subList2.size()) {
            T elem;
            if (subList1.get(s1).compareTo(subList2.get(s2)) == -1) {
                elem = subList1.get(s1++);
            } else {
                elem = subList2.get(s2++);
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
     * @param <T>  the type of the objects in the list
     * @return the list with the two sorted sublists merged (modifies original list)
     */
    private static <T extends Comparable<T>> ArrayList<T> merge(ArrayList<T> list, int s, int m, int e) {
        ArrayList<T> subList1 = new ArrayList<>(list.subList(s, m + 1));
        int s1 = 0;
        int s2 = m + 1;
        int i = s;
        while (s1 < subList1.size() && s2 < e + 1) {
            T elem;
            if (subList1.get(s1).compareTo(list.get(s2)) == -1) {
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
     * mergesort method that handles the sorting, uses indexes instead of splitting the ArrayList
     *
     * @param list the ArrayList to sort
     * @param s    the (inclusive) start index of the sublist to mergesort
     * @param e    the (inclusive) end index of the sublist to mergesort
     * @param <T>  the type of the objects in the list
     * @return the sublist in list sorted (modifies original list)
     */
    private static <T extends Comparable<T>> ArrayList<T> mergesort(ArrayList<T> list, int s, int e) {
        if (s == e) {
            return list;
        }
        if (e - s == 1) {
            return swapif(list, s, e);
        }
        int m = (e - s) / 2 + s;
        mergesort(list, s, m);
        mergesort(list, m + 1, e);
        return merge(list, s, m, e);
    }

    /**
     * Uses the merge sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> mergesort(ArrayList<T> list) {
        return mergesort(list, 0, list.size() - 1);
    }

    /**
     * Uses the merge sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] mergesort(T[] list) {
        return mergesort(new ArrayList<>(Arrays.asList(list))).toArray(list);
    }

    //endregion

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
        list.set(pivInd, list.get(e));
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

    /**
     * "Sifts down" the element at index 0 through the heap at the beginning of list (up to heapEnd)
     *
     * @param list the list containing the heap to sift the top value down of (list must be a heap up to index heapEnd)
     * @param heapEnd the index of the list where the heap stops
     * @param <T> the type of Objects in list
     * @return the list with the top value of the heap sifted down within the heap
     */
    private static <T extends Comparable<T>> ArrayList<T> siftDown(ArrayList<T> list, int heapEnd){
        int p = 1;
        int c = 2*p;
        T elem = list.get(p-1);
        while (c <= heapEnd){
            if (c<heapEnd && list.get(c).compareTo(list.get(c-1)) == 1){
                c += 1;
            }
            T bigChild = list.get(c-1);
            if (bigChild.compareTo(elem) == 1){
                list.set(p-1, bigChild);
                p = c;
                c = 2*p;
            }
            else {
                break;
            }
        }
        list.set(p-1, elem);
        return list;
    }

    /**
     * Uses the heap sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> heapsort(ArrayList<T> list){
        heapify(list);
        for (int i=list.size()-1; i>0; i--){
            T elem = list.get(i);
            list.set(i, list.get(0));
            list.set(0, elem);
            siftDown(list, i);
        }
        return list;
    }

    /**
     * Uses the quick sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] heapsort(T[] list) {
        return heapsort(new ArrayList<>(Arrays.asList(list))).toArray(list);
    }

    //endregion

    //region Experimental Sorts


    //endregion

}