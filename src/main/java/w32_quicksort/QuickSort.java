package w32_quicksort;

import w22_elementary_sorts.Util;

import java.util.Arrays;

import static w22_elementary_sorts.Util.*;

/**
 * Created by sandro on 2/5/15.
 */
public class QuickSort {
    public static int[] sort(int[] arr) {
        // must shuffle to get nlogn every time for any input
        return sort(arr, 0, arr.length - 1);
//        return sort3way(arr, 0, arr.length - 1);
//        return arr;
    }

    public static int[] sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return arr;
        }
        int pivotIndex = partition(arr, lo, hi);
        sort(arr, lo, pivotIndex - 1);
        sort(arr, pivotIndex + 1, hi);
        return arr;
    }

    /**
     * Original idea to make code easier to understand belongs to -> Vato Maskhulia
     */
    private static int partition(int[] arr, int firstIndex, int lastIndex) {
        int lo = firstIndex + 1; // we skip firstIndex because it is pivot. but why?
        int hi = lastIndex;
        int pivot = arr[firstIndex];

        /** invariant: [start, lo-1] <= pivot
         *             [lo, hi]      [not seen]
         *             [hi+1, hi]    >=  pivot
         */

        // does this have same algorithmic guarantee as sedgewick's?
        while (true) {
            while (lo <= lastIndex && arr[lo] <= pivot) {
                lo++;
            }

            while (hi > firstIndex && arr[hi] >= pivot) {
                hi--;
            }

            if (lo >= hi) {
                break;
            }
            swap(arr, lo, hi);
        }

        swap(arr, firstIndex, hi);

        return hi;
    }

    private static int partitionSedgewick(int[] a, int lo, int hi) {
        // I hav hard time understanding this algorithm, it is quite complex
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {

            // find item on lo to swap
            while (a[++i] < v)
                if (i == hi) break;

            // find item on hi to swap
            while (v < a[--j])
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            swap(a, i, j);
        }

        // put partitioning item v at a[j]
        swap(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    public static int[] sort3way(int[] arr, int firstIndex, int lastIndex) {
        if (firstIndex >= lastIndex) {
            return arr;
        }

        int lo = firstIndex;
        int mid = firstIndex;
        int hi = lastIndex;
        int pivot = arr[firstIndex];

        /* invariant: [start,lo-1]  < pivot
         *            [lo,mid-1]   == pivot
         *            [mid, hi]    [not yet seen]
         *            [hi+1,end]    > pivot
         */

        while (mid <= hi) {
            if (arr[mid] < pivot) {
                swap(arr, mid, lo);
                mid++;
                lo++;
            } else if (arr[mid] > pivot) {
                swap(arr, mid, hi);
                hi--;
            } else {
                mid++;
            }
        }

        sort3way(arr, firstIndex, lo - 1);
        sort3way(arr, hi + 1, lastIndex);

        return arr;
    }

    private static int[] partition3way(int[] arr, int firstIndex, int lastIndex) {
        int lo = firstIndex;
        int mid = firstIndex;
        int hi = lastIndex;
        int pivot = arr[firstIndex];

        while (mid <= hi) {
            if (arr[mid] < pivot) {
                swap(arr, mid, lo);
                mid++;
                lo++;
            } else if (arr[mid] > pivot) {
                swap(arr, mid, hi);
                hi--;
            } else {
                mid++;
            }
        }

        return arr;
    }

    // this code seems to be wrong
    private static int partitionWrong(int[] arr, int firstIndex, int lastIndex) {
        int lo = firstIndex + 1;
        int hi = lastIndex;
        int pivot = arr[firstIndex];

        /** invariant: [start, lo-1] < pivot
         *             [lo, hi]      [not seen]
         *             [hi+1, hi]    > pivot
         *  where do equal things go?
         *  does this code actually work?
         *  does it do more swaps than the above? probably yes?
         *  is it clearer? hell yes :)
         */

        while (lo < hi) {
            if (arr[lo] < pivot) {
                lo++;
            } else if (arr[lo] > pivot) {
                Util.swap(arr, lo, hi);
                hi--;
            } else /* arr[i] == pivot */ {
                // why is this step necessary?
                Util.swap(arr, lo, hi);
            }
        }

        swap(arr, firstIndex, hi);

        return hi;
    }



//    private static int partition(int[] arr, int lo, int hi) {
//        int pivot = arr[0];
//
//        while (lo < hi) {
//            if (arr[lo] <= pivot) {
//                lo++;
//            } else {
//                Util.swap(arr, lo, hi);
//                hi--;
//            }
//        }
//
//        return lo;
//    }

    public static void main(String[] args) {
                   //B  B  A  A  B  B  B  B  B  B  A  B
        int[] arr = {57, 57, 80, 21, 57, 65, 73, 99, 44, 15  };
        System.out.println(partition3way(arr, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print((char) arr[i] + " ");
//        }
    }
}
