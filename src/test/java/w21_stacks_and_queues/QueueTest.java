package w21_stacks_and_queues;

import junit.framework.TestCase;

import java.util.Iterator;

public class QueueTest extends TestCase {
    private Queue<Integer> queue;

    @Override
    public void setUp() {
        queue = new LinkedListQueueWithSentinel<>();
    }

    public void testQueue() {
        assertTrue(queue.isEmpty());
        queue.enqueue(10);
        assertTrue(!queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals((Integer) 10, queue.peek());
        assertEquals((Integer) 10, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    public void testIterator() {
        queue.enqueue(10);
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(2);

        Iterator<Integer> it = queue.iterator();
        assertTrue(it.hasNext());
        assertEquals((Integer) 1, it.next());
        assertTrue(it.hasNext());
        assertEquals((Integer) 2, it.next());
        assertFalse(it.hasNext());
    }

    public void testResizing() {
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
        }
        assertEquals(100, queue.size());
        for (int i = 0; i < 100; i++) {
            assertEquals((Integer) i, queue.dequeue());
        }
        assertTrue(queue.isEmpty());
    }
}