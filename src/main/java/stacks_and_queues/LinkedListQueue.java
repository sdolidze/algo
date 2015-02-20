package stacks_and_queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * state machine:
 *      size  = 0 => invariant: first  = last  = null
 *      size  = 1 => invariant: first  = last != null
 *      size >= 2 => invariant: first != last != null
 *
 * can using sentinel make code easier?
 */
public class LinkedListQueue<T> implements Queue<T> {
    private static class Node<T> {
        private T elem;
        private Node<T> next;

        public Node(T elem) {
            this.elem = elem;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedListQueue() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void enqueue(T elem) {
        if (size == 0) {
            first = new Node(elem);
            last = first;
        } else /* size == 1 || size >= 2 */ {
            last.next = new Node(elem);
            last = last.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("cannot dequeue empty queue");
        }
        T elem = first.elem;
        if (size == 1) {
            first = null;
            last = null;
        } else /* size >= 2 */ {
            first = first.next;
        }
        size--;
        return elem;
    }

    @Override
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("cannot dequeue empty queue");
        }
        return first.elem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> head = first;

            @Override
            public boolean hasNext() {
                return head != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T elem = head.elem;
                head = head.next;
                return elem;
            }
        };
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedListQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.forEach(System.out::println);
    }
}
