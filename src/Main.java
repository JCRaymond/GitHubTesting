import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 12/14/2016.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(new Integer[]{3,6,2,6,9,5,6,1,0,2}));
        System.out.println(nums);
        nums = Sorting.bubblesort(nums);
        System.out.println(nums);
    }
}
