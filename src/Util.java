import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Jacob on 12/14/2016.
 * Utility class with useful methods to be used for a wide variety of things
 */
public class Util {

    private Util() {
    }

    /**
     * Generic OutputStream write handling for displaying Arrays
     *
     * @param array the Array to print
     * @param <T>   the type of the objects in array
     */
    public static <T> void printar(T[] array, OutputStream os) {
        StringBuilder out = new StringBuilder("[");
        for (T elem : array) {
            out.append(elem.toString()).append(", ");
        }
        out.delete(out.length() - 2, out.length()).append("]\n");
        try {
            os.write(out.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Override: Specific case to use System.out instead of specifying OutputStream
     *
     * @param array the Array to print
     * @param <T>   the type of the objects in array
     */
    public static <T> void printar(T[] array) {
        Util.printar(array, System.out);
    }
}
