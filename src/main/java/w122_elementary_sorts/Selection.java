package w122_elementary_sorts;

/**
 * Created by sandro on 2/2/15.
 */
public class Selection implements Sorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            Util.swap(arr, min, i);
        }
    }
}
