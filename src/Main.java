import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 12/14/2016.
 * Main class with test cases, no particular functionality
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(new Integer[]{3,6,2,6,9,5,6,1,0,2}));
        System.out.println(nums);
        Sorting.insertsort(nums);
        System.out.println(nums);
//        Double[] nums = new Double[]{3., 6., 2., 6., 9., 5., 6., 1., 0., 2., .12, 5.123};
//        Util.printar(nums);
//        Sorting.bubblesort(nums);
//        Util.printar(nums);
    }
}
