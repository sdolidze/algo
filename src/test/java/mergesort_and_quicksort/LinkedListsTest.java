package mergesort_and_quicksort;

import junit.framework.TestCase;

import static mergesort_and_quicksort.LinkedLists.*;
import static mergesort_and_quicksort.LinkedLists.Node.*;

public class LinkedListsTest extends TestCase {

    public void testMiddle() throws Exception {
//        assertEquals(null, middle(null));
//        assertEquals(1, middle(list(1)).elem);
//        assertEquals(2, middle(list(1, 2)).elem);
//        assertEquals(2, middle(list(1, 2, 3)).elem);
//        assertEquals(3, middle(list(1, 2, 3, 4)).elem);
    }

    public void testSort() {
//        assertTrue(same(list(1), mergeSort(list(1), null)));
//        assertTrue(same(list(1,2), mergeSort(list(1,2), null)));
//        assertTrue(same(list(1,2), mergeSort(list(2,1), null)));
//        assertTrue(same(list(1,2,3), mergeSort(list(3,1,2), null)));
//        assertTrue(same(list(5,5,5), mergeSort(list(5,5,5), null)));
//        assertTrue(same(list(1,1,2,2), mergeSort(list(2,2,1,1), null)));
//        assertTrue(same(list(1,2,3,4), mergeSort(list(4,3,2,1), null)));

        Node a = mergeSort(list(4,3,2,1), null);

        int x = 0;
//        assertTrue(same(list(1,1,2,2,5,5), mergeSort(list(5,2,2,1,1,5), null)));
    }
}