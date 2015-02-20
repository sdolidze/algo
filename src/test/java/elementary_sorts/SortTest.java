package elementary_sorts;

import junit.framework.TestCase;

import java.util.Arrays;

public class SortTest extends TestCase {
    public void testAlreadySorted() {
        Sorter sorter = new Insertion();
        assertSorted(sorter);
        assertSorted(sorter, 1);
        assertSorted(sorter, 1, 2);
        assertSorted(sorter, 2, 1);
        assertSorted(sorter, 1, 2, 3);
        assertSorted(sorter, 2, 1, 3);
        assertSorted(sorter, 3, 2, 1);
    }

    public<T> void assertSorted(Sorter sorter, Integer... arr) {
        int[] intArr = toIntArray(arr);
        sorter.sort(intArr);
        assertTrue(isSorted(intArr));
    }

    public<T> boolean isSorted(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            if (arr[i-1] >= arr[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] toIntArray(Integer... arr) {
        int[] res = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}