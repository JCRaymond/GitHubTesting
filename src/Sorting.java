import java.util.ArrayList;

/**
 * Created by Jacob on 12/14/2016.
 */
public class Sorting {

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
}
