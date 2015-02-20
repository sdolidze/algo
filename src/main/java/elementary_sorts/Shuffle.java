package elementary_sorts;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Created by sandro on 2/4/15.
 */
public class Shuffle {
    private static final Random random = new Random();

    public static void shuffle(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = random.nextInt(i + 1); // [0, i]
            swap(arr, i, j);
        }
    }

    // has same effect as first one
    // is this any better than the previous implementation
    public static void shuffle2(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i + random.nextInt(arr.length - i); // [i, length)
            swap(arr, i, j);
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5};
        shuffle2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
