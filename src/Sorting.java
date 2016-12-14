import java.util.ArrayList;

/**
 * Created by Jacob on 12/14/2016.
 */
public class Sorting {

    public static <T extends Comparable<T>> ArrayList<T> bubblesort(ArrayList<T> list){
        ArrayList<T> sorted = (ArrayList<T>) list.clone();
        for (int i = sorted.size()-1; i>=0; i--){
            for (int j=0; j<i; j++){
                if (sorted.get(j).compareTo(sorted.get(j+1)) == 1){
                    T temp = sorted.get(j);
                    sorted.set(j, sorted.get(j+1));
                    sorted.set(j+1, temp);
                }
            }
        }
        return sorted;
    }
}
