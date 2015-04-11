package w151_balanced_search_trees;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

public class RedBlackTreeTest {
    private RedBlackTree<Integer, Integer> xs;

    @Before
    public void setUp() {
        xs = new RedBlackTree<>();
    }

    @Test
    public void testKeysAndValues() {
        xs.put(1, 5);
        xs.put(4, 4);
        xs.put(3, 3);
        xs.put(3, 9);
        xs.put(2, 2);
        assertEquals(asList(1, 2, 3, 4), xs.keys());
        assertEquals(asList(5, 2, 9, 4), xs.values());
        System.out.println(xs);
        System.out.println(xs.levelOrder());
    }
}