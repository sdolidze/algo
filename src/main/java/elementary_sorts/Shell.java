package elementary_sorts;

import java.util.Arrays;

/**
 * Created by sandro on 2/4/15.
 */
public class Shell implements Sorter {
    @Override
    public void sort(int[] arr) {
        int h = 1;
        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        while (h < arr.length / 3) {
            h = h*3 + 1;
        }
        while (h >= 1) {
            hsort(arr, h);
            h /= 3;
        }
    }

    public void hsort(int[] arr, int h) {
        for (int i = h; i < arr.length; i++) {
            for (int j = i; j - h >= 0; j -= h) {
                if (arr[j - h] > arr[j]) {
                    Util.swap(arr, j - h, j);
                } else {
                    break;
                }
            }
        }

    }

    public boolean isHsorted(int[] arr, int h) {
        for (int i = h; i < arr.length; i++) {
            if (arr[i-h] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,2,1,4,5,1};
        Shell shell = new Shell();
        shell.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
