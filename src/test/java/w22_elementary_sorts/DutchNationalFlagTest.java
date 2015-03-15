package w22_elementary_sorts;

import junit.framework.TestCase;

import static w22_elementary_sorts.DutchNationalFlag.sortTwo;
import static org.junit.Assert.assertArrayEquals;

public class DutchNationalFlagTest extends TestCase {
    public void testEmpty() {
        assertArrayEquals(new int[]{}, sortTwo(new int[]{}));
    }

    public void testOne() {
        assertArrayEquals(new int[]{1}, sortTwo(new int[]{1}));
        assertArrayEquals(new int[]{0}, sortTwo(new int[]{0}));
    }

    public void testTwo() {
        assertArrayEquals(new int[]{0,0}, sortTwo(new int[]{0,0}));
        assertArrayEquals(new int[]{0,1}, sortTwo(new int[]{0,1}));
        assertArrayEquals(new int[]{0,1}, sortTwo(new int[]{1,0}));
        assertArrayEquals(new int[]{1,1}, sortTwo(new int[]{1,1}));
    }

    public void testEdge() {
        assertArrayEquals(new int[]{0,0,1,1}, sortTwo(new int[]{0,0,1,1}));
        assertArrayEquals(new int[]{0,0,1,1}, sortTwo(new int[]{1,1,0,0}));
        assertArrayEquals(new int[]{0,0,1,1}, sortTwo(new int[]{0,1,1,0}));
        assertArrayEquals(new int[]{0,1,1,1}, sortTwo(new int[]{1,0,1,1}));
    }
}