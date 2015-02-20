package stacks_and_queues;

import junit.framework.TestCase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackTest extends TestCase {
    private Stack<Integer> stack;

    @Override
    public void setUp() {
        stack = new ArrayStack<>();
    }

    public void test1() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        assertTrue(!stack.isEmpty());
        assertEquals(2, stack.size());
        assertEquals((Integer) 20, stack.pop());
        assertEquals((Integer) 10, stack.peek());
        assertEquals((Integer) 10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    public void testIterator() {
        assertFalse(stack.iterator().hasNext());

        stack.push(1);
        stack.push(2);

        Iterator<Integer> it = stack.iterator();
        assertTrue(it.hasNext());
        assertEquals((Integer) 2, it.next());
        assertTrue(it.hasNext());
        assertEquals((Integer) 1, it.next());
        assertFalse(it.hasNext());
    }

    public void testResizing() {
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        assertEquals(100, stack.size());
        for (int i = 99; i >= 0; i--) {
            assertEquals((Integer) i, stack.pop());
        }
        assertTrue(stack.isEmpty());
    }
//
//    public void testEdgeCases() {
//        stack.push(1);
//        stack.pop();
//        stack.push(2);
//        stack.push(3);
//        stack.pop();
//        stack.pop();
//        stack.push(4);
//        assertEquals((Integer) 4, stack.pop());
//
//        try {
//            stack.pop();
//            fail();
//        } catch (NoSuchElementException e) {
//            // expected exception
//        }
//    }
}