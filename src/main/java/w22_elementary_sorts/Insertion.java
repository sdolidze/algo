package w22_elementary_sorts;

import static w22_elementary_sorts.Util.*;

/**
 * Created by sandro on 2/2/15.
 */
public class Insertion implements Sorter {
    @Override
    public void sort(int[] arr) {
        insertionSortLessComplex(arr);
//        for (int i = 0; i < arr.length; i++) {
//            int j = i;
//            while (j >= 1 && arr[j-1] > arr[j]) {
//                swap(arr, j - 1, j);
//                j--;
//            }
//        }
    }

    private void insertionSortSmallYetComplex(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j-1] > arr[j]; j--)
                swap(arr, j - 1, j);
    }

    private void insertionSortLessComplex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}
