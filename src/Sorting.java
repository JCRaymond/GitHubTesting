import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 12/14/2016.
 * Class with a
 */
public class Sorting {

    private Sorting(){}

    public static <T extends Comparable<T>> void bubblesort(ArrayList<T> list){
        for (int i = list.size()-1; i>=0; i--){
            for (int j=0; j<i; j++){
                if ( list.get(j).compareTo( list.get(j+1)) == 1){
                    T temp =  list.get(j);
                     list.set(j,  list.get(j+1));
                     list.set(j+1, temp);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> T[] bubblesort(T[] list){
        if (list.length == 0){
            return list;
        }
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(list));
        bubblesort(arrayList);
        return arrayList.toArray((T[])Array.newInstance(list[0].getClass(), list.length));
    }
}
