package w141_priority_queue;

import junit.framework.TestCase;

import java.util.*;

public class PriorityQueueTest extends TestCase {
    private PriorityQueue<Integer> queue;

    @Override
    public void setUp() {
        queue = new BinaryHeapPriorityQueue<>(3);
    }

    public void testEmpty() {
        try {
            queue.max();
            fail();
        } catch (NoSuchElementException e) { /*ignored*/ }
        assertFalse(queue.iterator().hasNext());
    }

    public void testOne() {
        queue.insert(1);
        assertEquals((Integer) 1, queue.max());
        assertEquals((Integer) 1, queue.iterator().next());
    }

    public void testMax() {
        queue.insert(1);
        queue.insert(3);
        queue.insert(2);
        assertEquals((Integer) 3, queue.max());
        assertEquals(set(1, 2, 3), fromIterable(queue));
    }

    public void testDelMax() {
        queue.insert(1);
        queue.insert(3);
        queue.insert(2);

        assertEquals((Integer) 3, queue.delMax());
        assertEquals(set(1,2), fromIterable(queue));

        assertEquals((Integer) 2, queue.delMax());
        assertEquals(set(1), fromIterable(queue));

        assertEquals((Integer) 1, queue.delMax());
        assertFalse(queue.iterator().hasNext());
    }

    public<T> Set<T> fromIterable(Iterable<T> it) {
        Set<T> arr = new HashSet<>();
        for (T elem: it) {
            arr.add(elem);
        }
        return arr;
    }

    public<T> Set<T> set(T... xs) {
        return new HashSet<>(Arrays.asList(xs));
    }
}