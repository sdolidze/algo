package w141_priority_queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sandro on 2/16/15.
 */
public class LinkedListPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private static class Node<T> {
        private T elem;
        private Node<T> next;

        private Node(T elem, Node<T> next) {
            this.elem = elem;
            this.next = next;
        }
    }

    // first element is always sentinel
    private Node<T> head;
    private Node<T> last;
    private int size;


    public LinkedListPriorityQueue() {
        Node sentinel = new Node(null, null);
        head = sentinel;
        last = sentinel;
        size = 0;
    }

    @Override
    public void insert(T elem) {
        last.next = new Node(elem, null);
        last = last.next;
        size++;
    }

    @Override
    public T delMax() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        size--;
        // todo: convert tail recursion to iteration
        return maxAndDel(head.next, head.next.next, head, head.next);
    }

    private T maxAndDel(Node<T> prev, Node<T> cur, Node<T> maxPrev, Node<T> maxCur) {
        if (cur == null) {
            maxPrev.next = maxCur.next;
            return maxCur.elem;
        } else if (cur.elem.compareTo(maxCur.elem) > 0) {
            return maxAndDel(cur, cur.next, prev, cur);
        } else {
            return maxAndDel(cur, cur.next, maxPrev, maxCur);
        }
    }

    @Override
    public T max() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        T max = head.next.elem;
        for (Node<T> cur = head.next.next; cur != null; cur = cur.next) {
            if (cur.elem.compareTo(max) > 0) {
                max = cur.elem;
            }
        }

        return max;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> cur = head.next;

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
