import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 12/14/2016.
 * Class with a variety of sorting algorithms, cannot be instantiated
 */
public class Sorting {

    private Sorting() {
    }

    //region Bubble Sort

    /**
     * Uses the bubble sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     */
    public static <T extends Comparable<T>> void bubblesort(ArrayList<T> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) == 1) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Uses the bubble sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void bubblesort(T[] list) {
        if (list.length == 0) {
            return;
        }
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(list));
        bubblesort(arrayList);
        arrayList.toArray(list);
    }

    //endregion

    //region Insert Sort

    /**
     * Uses the insert sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     */
    public static <T extends Comparable<T>> void insertsort(ArrayList<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T elem = list.get(i);
            int newIndex = i - 1;
            while (newIndex >= 0 && list.get(newIndex).compareTo(elem) == 1) {
                list.set(newIndex + 1, list.get(newIndex));
                newIndex--;
            }
            list.set(newIndex + 1, elem);
        }
    }

    /**
     * Uses the insert sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     */
    public static <T extends Comparable<T>> void insertsort(T[] list) {
        if (list.length == 0) {
            return;
        }
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(list));
        insertsort(arrayList);
        arrayList.toArray(list);
    }

    //endregion

    //region Selection Sort

    /**
     * Uses the bubble sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     */
    public static <T extends Comparable<T>> void selectsort(ArrayList<T> list) {
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
    }

    /**
     * Uses the bubble sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void selectsort(T[] list) {
        if (list.length == 0) {
            return;
        }
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(list));
        selectsort(arrayList);
        arrayList.toArray(list);
    }

    //endregion

    //region Merge Sort

    /**
     * merge function that merges two pre-sorted subsections of the list
     *
     * @param list the ArrayList which contains the two sublists
     * @param s    the (inclusive) start index of the first sublist
     * @param m    the (inclusive) end index of the first sublist
     *              (m+1) is the (inclusive) start of the second sublist
     * @param e    the (inclusive) end index of the second sublist
     * @param <T>  the type of the objects in the list
     */
    private static <T extends Comparable<T>> void merge(ArrayList<T> list, int s, int m, int e) {
        ArrayList<T> subList1 = new ArrayList<>(list.subList(s, m + 1));
        ArrayList<T> subList2 = new ArrayList<>(list.subList(m + 1, e + 1));
        int s1 = 0;
        int s2 = 0;
        int i = s;
        while(s1<subList1.size() && s2<subList2.size()){
            T elem;
            if (subList1.get(s1).compareTo(subList2.get(s2)) == -1){
                elem = subList1.get(s1++);
            }
            else{
                elem = subList2.get(s2++);
            }
            list.set(i++, elem);
        }
        while(s1<subList1.size()){
            list.set(i++, subList1.get(s1++));
        }
        while(s2<subList2.size()){
            list.set(i++, subList2.get(s2++));
        }
    }

    /**
     * mergesort method that handles the sorting, uses indexes instead of splitting the ArrayList
     *
     * @param list the ArrayList to sort
     * @param s    the (inclusive) start index to mergesort
     * @param e    the (inclusive) end index t0 mergesort
     * @param <T>  the type of the objects in the list
     */
    private static <T extends Comparable<T>> void mergesort(ArrayList<T> list, int s, int e) {
        if (s == e) {
            return;
        }
        if (e - s == 1) {
            if (list.get(s).compareTo(list.get(e)) == 1) {
                T elem = list.get(s);
                list.set(s, list.get(e));
                list.set(e, elem);
            }
            return;
        }
        int m = (e - s) / 2 + s;
        mergesort(list, s, m);
        mergesort(list, m + 1, e);
        merge(list, s, m, e);
    }

    /**
     * Uses the merge sort algorithm to sort a generic ArrayList
     *
     * @param list the ArrayList to sort
     * @param <T>  the type of the objects in list
     */
    public static <T extends Comparable<T>> void mergesort(ArrayList<T> list) {
        mergesort(list, 0, list.size() - 1);
    }

    /**
     * Uses the merge sort algorithm to sort a generic Array
     *
     * @param list the Array to sort
     * @param <T>  the type of the objects in list
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void mergesort(T[] list) {
        if (list.length == 0) {
            return;
        }
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(list));
        mergesort(arrayList);
        arrayList.toArray(list);
    }

    //endregion

}
