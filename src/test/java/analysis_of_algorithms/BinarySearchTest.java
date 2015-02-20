package analysis_of_algorithms;

import junit.framework.TestCase;

public class BinarySearchTest extends TestCase {
    public void testBinarySearch() {
        assertEquals(3, BinarySearch.binarySearch(new int[] {0,1,2,3,4}, 3));
    }


    public void testInfectionPoint() {
        assertEquals(1, BinarySearch.bitonicMax(new int[]{5, 90, 70}));
        assertEquals(1, BinarySearch.bitonicMax(new int[]{5, 90, 70, 50, 10, 5}));
        assertEquals(3, BinarySearch.bitonicMax(new int[]{5, 10, 15, 90, 70}));
        assertEquals(4, BinarySearch.bitonicMax(new int[]{5, 10, 15, 25, 90, 70, 50, 30}));
    }

    public void testBitonicSearch() {
        assertEquals(7, BinarySearch.bitonicSearch(new int[]{5, 90, 15, 25, 90, 70, 50, 30}, 30));
        assertEquals(0, BinarySearch.bitonicSearch(new int[]{5, 90, 15, 25, 90, 70, 50, 30}, 5));
        assertEquals(4, BinarySearch.bitonicSearch(new int[]{5, 90, 15, 25, 90, 70, 50, 30}, 90));

        assertEquals(0, BinarySearch.bitonicSearch(new int[]{1, 3, 2}, 1));
        assertEquals(1, BinarySearch.bitonicSearch(new int[]{1, 3, 2}, 3));
        assertEquals(2, BinarySearch.bitonicSearch(new int[]{1, 3, 2}, 2));
    }
}