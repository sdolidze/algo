package w132_quicksort;

import junit.framework.TestCase;

import static w141_priority_queue.BottomUpHeapSort.sort;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest extends TestCase {
    public void testEmpty() {
        assertArrayEquals(a(), sort(a()));
    }

    public void test1() {
        assertArrayEquals(a(1), sort(a(1)));
        assertArrayEquals(a(0), sort(a(0)));
    }

    public void test2() {
        assertArrayEquals(a(0,1), sort(a(0,1)));
        assertArrayEquals(a(3,5), sort(a(5,3)));
    }

    public void test3() {
        assertArrayEquals(a(0,1,2), sort(a(0,1,2)));
        assertArrayEquals(a(1,3,5), sort(a(5,3,1)));
        assertArrayEquals(a(0, 2, 4), sort(a(0, 4, 2)));
        assertArrayEquals(a(2,10,10), sort(a(10,2,10)));
    }

    public void test4() {
        assertArrayEquals(a(0,0,1,1), sort(a(1,1,0,0)));
        assertArrayEquals(a(1,5,5,5), sort(a(5,5,5,1)));
        assertArrayEquals(a(0,0,1,1), sort(a(1,0,1,0)));
        assertArrayEquals(a(1,2,3,4), sort(a(4,3,2,1)));
    }

    public void test5() {
        assertArrayEquals(a(2,2,2), sort(a(2,2,2)));
        assertArrayEquals(a(1,1,1,1), sort(a(1,1,1,1)));
        assertArrayEquals(a(1,1,1,2,2,2), sort(a(1,2,1,2,1,2)));
        assertArrayEquals(a(1,1,1,2,2,2,3,3,3), sort(a(3,2,1,1,2,3,3,2,1)));
        assertArrayEquals(a(0,0,0,0,0,0,0,1,1,1,1,1), sort(a(0,1,0,0,1,1,0,0,1,0,1,0)));
    }

    private static int[] a(Integer... xs) {
        int[] ys = new int[xs.length];
        for (int i = 0; i < xs.length; i++) {
            ys[i] = xs[i];
        }
        return ys;
    }
}