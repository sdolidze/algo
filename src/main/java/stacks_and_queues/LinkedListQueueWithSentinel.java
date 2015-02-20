package stacks_and_queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * using sentinel removes all edge cases :)
 * first is always sentinel, first.next is first element
 * careful: there is a loop in a list, so take it into consideration
 */
public class LinkedListQueueWithSentinel<T> implements Queue<T> {
    private static class Node<T> {
        private T elem;
        private Node<T> next;

        private Node(T elem) {
            this.elem = elem;
        }

        private static void link(Node left, Node mid, Node right) {
            left.next = mid;
            mid.next = right;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedListQueueWithSentinel() {
        first = new Node<>(null);;
        last = first;
        size = 0;
    }

    @Override
    public void enqueue(T elem) {
        if (elem == null) {
            throw new NullPointerException();
        }
        last.next = new Node(elem);
        last = last.next;
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T elem = first.next.elem;
        first.next = first.next.next;
        size--;
        return elem;
    }

    @Override
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return first.next.elem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> cur = first.next;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T elem = cur.elem;
                cur = cur.next;
                return elem;
            }
        };
    }
}
