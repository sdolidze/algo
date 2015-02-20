package analysis_of_algorithms;

import java.util.Comparator;

/**
 * Created by sandro on 1/30/15.
 */
public class BinarySearch {
    public static int binarySearchTailRec(int[] arr, int key, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        if (key < arr[mid]) {
            return binarySearchTailRec(arr, key, lo, mid - 1);
        } else if (key > arr[mid]) {
            return binarySearchTailRec(arr, key, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static int binarySearchTailRec(int[] arr, int key) {
        return binarySearchTailRec(arr, key, 0, arr.length-1);
    }

    public static int binarySearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length-1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) {
                hi = mid - 1;
            } else if (key > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int binarySearchAdvanced(int[] arr, int key, Comparator<Integer> cmp, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (cmp.compare(key, arr[mid]) < 0) {
                hi = mid - 1;
            } else if (cmp.compare(key, arr[mid]) > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * complexity of this algorithm is ~3logn
     */
    public static int bitonicSearch(int[] arr, int key) {
        int indexOfMax = bitonicMax(arr);
        // look in ascending array
        int index = binarySearchAdvanced(arr, key, (x, y) -> x - y, 0, indexOfMax);

        if (index != -1) {
            return index;
        }

        //look in descending array
        return binarySearchAdvanced(arr, key, (x, y) -> y - x, indexOfMax + 1, arr.length - 1);
    }

    public static int bitonicMax(int[] arr) {
        if (arr.length < 3) {
            throw new AssertionError("array is not bitonic, it contains less than 3 elements");
        }

        int lo = 1;
        int hi = arr.length - 2;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
