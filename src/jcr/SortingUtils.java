package jcr;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by quatern10n on 12/20/16.
 * class containing a bunch of useful utilities for sorting
 */
public class SortingUtils {

    private SortingUtils(){}

    //region Enums

    /**
     * enum which allows to specify the sorting order
     */
    public enum SortingOrder {
        ASCENDING(-1), DESCENDING(1);

        private final int val;

        SortingOrder(int val) {
            this.val = val;
        }

        public int getValue() {
            return this.val;
        }
    }

    /**
     * enum which allows to specify the sorting algorithm to use
     */
    public enum SortingType {
        BUBBLE, INSERT, SELECTION, MERGE, QUICK, HEAP
    }

    //endregion

    //region Utilties

    //region Modifiers

    /**
     * Swaps the two elements at the indexes p1 and p2
     *
     * @param list the ArrayList containing the elements to swap
     * @param p1 the index of the first element
     * @param p2 the index of the second element
     * @param <T> the type of Objects in list
     * @return the list with the two elements swapped (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> swap(ArrayList<T> list, int p1, int p2){
        T elem = list.get(p1);
        list.set(p1, list.get(p2));
        list.set(p2, elem);
        return list;
    }

    /**
     * Swaps the two elements at the indexes p1 and p2
     *
     * @param list the Array containing the elements to swap
     * @param p1 the index of the first element
     * @param p2 the index of the second element
     * @param <T> the type of Objects in list
     * @return the list with the two elements swapped (modifies original list)
     */
    public static <T extends Comparable<T>> T[] swap(T[] list, int p1, int p2){
        T elem = list[p1];
        list[p1] = list[p2];
        list[p2] = elem;
        return list;
    }

    /**
     * Swaps the objects at position p1 and p2 in the list if the object at p1 is "greater" than the object at p2
     *
     * @param list the ArrayList containing the values
     * @param p1   the position of the first object
     * @param p2   the position of the second object
     * @param <T>  the type of the objects in list
     * @return the list with the two values swapped (modifies original list)
     */
    static <T extends Comparable<T>> ArrayList<T> swapif(ArrayList<T> list, int p1, int p2) {
        if (list.get(p1).compareTo(list.get(p2)) == 1) {
            swap(list, p1, p2);
        }
        return list;
    }

    /**
     * Swaps the objects at position p1 and p2 in the list if the object at p1 is "greater" than the object at p2
     *
     * @param list the Array containing the values
     * @param p1   the position of the first object
     * @param p2   the position of the second object
     * @param <T>  the type of the objects in list
     * @return the list with the two values swapped (modifies original list)
     */
    static <T extends Comparable<T>> T[] swapif(T[] list, int p1, int p2) {
        if (list[p1].compareTo(list[p2]) == 1) {
            swap(list, p1, p2);
        }
        return list;
    }

    /**
     * Converts the ArrayList into a heap (makes list follow the heap rule)
     *
     * @param list the ArrayList to make into a heap
     * @param <T>  the types of Objects in list
     * @return list as a heap (modifies original list)
     */
    public static <T extends Comparable<T>> ArrayList<T> heapify(ArrayList<T> list){
        for (int i=1; i<list.size(); i++){
            int c = i+1;
            int p = c/2;
            T elem = list.get(c-1);
            while(p > 0){
                T parent = list.get(p-1);
                if (elem.compareTo(parent) == 1){
                    list.set(c-1, parent);
                    c = p;
                    p = c/2;
                }
                else {
                    break;
                }
            }
            list.set(c-1, elem);
        }
        return list;
    }

    /**
     * Converts the Array into a heap (makes list follow the heap rule)
     *
     * @param list the Array to make into a heap
     * @param <T>  the types of Objects in list
     * @return list as a heap (modifies original list)
     */
    public static <T extends Comparable<T>> T[] heapify(T[] list) {
        return heapify(new ArrayList<>(Arrays.asList(list))).toArray(list);
    }

    //endregion

    //region Testers

    /**
     * Determines whether or not the ArrayList is sorted in the specified way
     *
     * @param list the ArrayList to determine if sorted
     * @param so   the way to check how the list is sorted
     * @param <T>  the type of objects in list
     * @return whether or not list is sort in the specified way
     */
    public static <T extends Comparable<T>> boolean isSorted(ArrayList<T> list, SortingOrder so) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) == -so.getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether or not the ArrayList is sorted in ascending order
     *
     * @param list the ArrayList to determine if sorted
     * @param <T>  the type of objects in list
     * @return whether or not list is sorted
     */
    public static <T extends Comparable<T>> boolean isSorted(ArrayList<T> list) {
        return isSorted(list, SortingOrder.ASCENDING);
    }

    /**
     * Determines whether or not the Array is sorted in the specified way
     *
     * @param list the ArrayList to determine if sorted
     * @param so   the way to check how the list is sorted
     * @param <T>  the type of objects in list
     * @return whether or not list is sort in the specified way
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] list, SortingOrder so) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i].compareTo(list[i + 1]) == -so.getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether or not the Array is sorted in ascending order
     *
     * @param list the ArrayList to determine if sorted
     * @param <T>  the type of objects in list
     * @return whether or not list is sorted
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] list) {
        return isSorted(list, SortingOrder.ASCENDING);
    }

    /**
     * Determines whether or not the ArrayList (up to heapEnd) is a heap
     *
     * @param list the ArrayList to determine if it is a heap (up to heapEnd
     * @param heapEnd where list stops being a heap
     * @param <T>  the type of objects in list
     * @return whether or not list (up to heapEnd) is a heap
     */
    public static <T extends Comparable<T>> boolean isHeap(ArrayList<T> list, int heapEnd) {
        for (int i = 1; i < heapEnd; i++) {
            if (list.get(i).compareTo(list.get(((i + 1) / 2) - 1)) == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether or not the ArrayList is a heap
     *
     * @param list the ArrayList to determine if it is a heap
     * @param <T>  the type of objects in list
     * @return whether or not list is a heap
     */
    public static <T extends Comparable<T>> boolean isHeap(ArrayList<T> list) {
        return isHeap(list, list.size());
    }

    /**
     * Determines whether or not the Array (up to heapEnd) is a heap
     *
     * @param list the Array to determine if it is a heap (up to heapEnd
     * @param heapEnd where list stops being a heap
     * @param <T>  the type of objects in list
     * @return whether or not list (up to heapEnd) is a heap
     */
    public static <T extends Comparable<T>> boolean isHeap(T[] list, int heapEnd) {
        for (int i = 1; i < heapEnd; i++) {
            if (list[i].compareTo(list[((i + 1) / 2) - 1]) == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether or not the Array is a heap
     *
     * @param list the Array to determine if it is a heap
     * @param <T>  the type of objects in list
     * @return whether or not list is a heap
     */
    public static <T extends Comparable<T>> boolean isHeap(T[] list) {
        return isHeap(list, list.length);
    }

    /**
     * method to determine if two lists contain the same values
     * (used to determine if a sorting algorithm has accidentally removed values)
     *
     * @param list1 the first list
     * @param list2 the second list
     * @param <T> the type of Objects in the lists
     * @return if the two lists contain the same values
     */
    public static <T> boolean containsSameVals(ArrayList<T> list1, ArrayList<T> list2){
        ArrayList<T> l2copy = (ArrayList<T>)(list2.clone());
        int ind;
        T elem;
        for (int i=0; i<list1.size(); i++){
            ind = l2copy.lastIndexOf(list1.get(i));
            if (ind < i) return false;
            elem = l2copy.get(i);
            l2copy.set(i, l2copy.get(ind));
            l2copy.set(ind, elem);
        }
        return l2copy.equals(list1);
    }

    //endregion

    //endregion

}
