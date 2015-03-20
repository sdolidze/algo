package w122_elementary_sorts;

import java.util.Arrays;

/**
 * Created by sandro on 2/5/15.
 */
public class DutchNationalFlag {
//    public static int[] sortTwo(int[] arr) {
//        // assert all(arr, x -> x == 0 || x == 1);
//
//        // invariant [0, lo-1]   -> 0s
//        //           [lo, hi]    -> unknown
//        //           [hi+1, N-1] -> 1s
//
//        int lo = 0;
//        int hi = arr.length - 1;
//
//        while (lo < hi) {
//            if (arr[lo] == 0) {
//                lo++;
//            } else /* arr[lo] == 1 */ {
//                Util.swap(arr, lo, hi);
//                hi--;
//            }
//        }
//
//        return arr;
//    }

    public static int[] sortTwo(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (true) {
            while (lo < arr.length && arr[lo] == 0) {
                lo++;
            }
            while (hi >= 0 && arr[hi] == 1) {
                hi--;
            }
            if (lo >= hi) {
                break;
            }
            Util.swap(arr, hi, lo);
        }

        return arr;
    }

    public static int[] sortThree(int[] arr) {
        // resembles very much 3-way partitioning in quick sort
        /**
         * invariant: [0, lo-1]   -> 0s
         *            [lo, mid-1] -> 1s
         *            [mid, hi]   -> unknown
         *            [hi+1, N-1] -> 2s
         */
        int lo = 0;
        int mid = 0;
        int hi = arr.length - 1;

        while (mid <= hi) {
            if (arr[mid] == 0) {
                Util.swap(arr, lo, mid);
                lo++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else /* arr[mid] == 2 */ {
                Util.swap(arr, mid, hi);
                hi--;
            }
        }

        System.out.printf("0s -> %d\n", lo);
        System.out.printf("1s -> %d\n", mid - lo);
        System.out.printf("2s -> %d\n", arr.length - mid); // mid = hi + 1 because (hi + 1) - (mid - 1) = 1

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,1,2,2,2,2,0,0,0,2};
        System.out.println(Arrays.toString(sortThree(arr)));
    }

}
