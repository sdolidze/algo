package stacks_and_queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sandro on 1/31/15.
 */
public class LinkedListStack<T> implements Stack<T> {
    private static class Node<T> {
        public T elem;
        public Node<T> next;

        public Node(T elem, Node<T> next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    public LinkedListStack() {
        head = null;
        size = 0;
    }

    @Override
    public void push(T elem) {
        head = new Node(elem, head);
        size++;
    }

    @Override
    public T pop() {
        if (head == null) {
            throw new NoSuchElementException("unable to pop empty stack");
        }
        T elem = head.elem;
        head = head.next;
        size--;
        return elem;
    }

    @Override
    public T peek() {
        return head.elem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> cur = head;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("empty stack");
                }
                T elem = cur.elem;
                cur = cur.next;
                return elem;
            }
        };
    }
}
