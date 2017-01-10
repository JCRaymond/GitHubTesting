package jcr;

import java.util.ArrayList;
import jcr.SortingUtils.SortingOrder;

import static jcr.SortingUtils.heapify;
import static jcr.SortingUtils.swap;

public class HeapSort {

    /**
     * "Sifts down" the element at index 0 through the heap at the beginning of list (up to heapEnd)
     *
     * @param list the list containing the heap to sift the top value down of (list must be a heap up to index heapEnd)
     * @param heapEnd the index of the list where the heap stops
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T> the type of Objects in list
     * @return the list with the top value of the heap sifted down within the heap
     */
    private static <T extends Comparable<T>> ArrayList<T> siftDown(ArrayList<T> list, int heapEnd, SortingOrder so){
        int p = 1;
        int c = 2*p;
        T elem = list.get(p-1);
        while (c <= heapEnd){
            if (c<heapEnd && list.get(c).compareTo(list.get(c-1)) == -so.getValue()){
                c += 1;
            }
            T bigChild = list.get(c-1);
            if (bigChild.compareTo(elem) == -so.getValue()){
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
     * "Sifts down" the element at index 0 through the heap at the beginning of list (up to heapEnd)
     *
     * @param list the list containing the heap to sift the top value down of (list must be a heap up to index heapEnd)
     * @param heapEnd the index of the list where the heap stops
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T> the type of Objects in list
     * @return the list with the top value of the heap sifted down within the heap
     */
    private static <T extends Comparable<T>> T[] siftDown(T[] list, int heapEnd, SortingOrder so){
        int p = 1;
        int c = 2*p;
        T elem = list[p-1];
        while (c <= heapEnd){
            if (c<heapEnd && list[c].compareTo(list[c-1]) == -so.getValue()){
                c += 1;
            }
            T bigChild = list[c-1];
            if (bigChild.compareTo(elem) == -so.getValue()){
                list[p-1] = bigChild;
                p = c;
                c = 2*p;
            }
            else {
                break;
            }
        }
        list[p-1] = elem;
        return list;
    }

    /**
     * Uses the heap sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> heapsort(ArrayList<T> list, SortingOrder so){
        heapify(list, so);
        for (int i=list.size()-1; i>0; i--){
            swap(list, i, 0);
            siftDown(list, i, so);
        }
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
        return heapsort(list, SortingOrder.ASCENDING);
    }

    /**
     * Uses the quick sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param so an enum value dictating whether to sort in ascending or descending order
     * @param <T>  the type of the objects in list
     * @return the sorted list (modifies original list)
     */
    public static <T extends Comparable<T>> T[] heapsort(T[] list, SortingOrder so) {
        heapify(list, so);
        for (int i=list.length; i>0; i--){
            swap(list, i, 0);
            siftDown(list, i, so);
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
        return heapsort(list, SortingOrder.ASCENDING);
    }
}
