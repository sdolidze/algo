package mergesort_and_quicksort;

/**
 * Created by sandro on 2/6/15.
 */
public class MergeSort {
    public static int[] sort(int[] arr) {
        int[] aux = new int[arr.length];
        return sort(arr, aux, 0, arr.length - 1);
    }

    private static int[] sortBottomUp(int[] arr) {
        int[] aux = new int[arr.length];
        // size tells use what lengths of arrays are sorted
        // at first we assume that every array of length 1 is sorted
        for (int size = 1; size < arr.length; size *= 2) {
            for (int i = 0; i < arr.length - size; i += size*2) {
                int lo = i;
                int mid = i + size - 1;
                int hi = Math.min(i + size * 2 - 1, arr.length - 1);
                merge(arr, aux, lo, mid, hi);
            }
        }
        return arr;
    }

    public static int[] sort(int[] arr, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return arr;
        }

        int mid = (lo + hi) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
        return arr;
    }

    public static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
        // assert isSorted(arr, lo, mid);
        // assert isSorted(arr, mid + 1, hi);

        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }

        int left = lo;
        int right = mid + 1;

        for (int i = lo; i <= hi; i++) {
            if (left > mid) { // left is empty
                arr[i] = aux[right++];
            } else if (right > hi) { // right is empty
                arr[i] = aux[left++];
            } else if (aux[left] > aux[right]) {
                arr[i] = aux[right++];
            } else /* aux[left] <= aux[right] */ {
                arr[i] = aux[left++];
            }
        }

        // assert isSorted(arr, lo, hi);
    }
}
