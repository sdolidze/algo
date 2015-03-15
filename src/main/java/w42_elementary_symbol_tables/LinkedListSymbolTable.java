package w42_elementary_symbol_tables;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sandro on 3/15/15.
 * could sentinel help?
 */
public class LinkedListSymbolTable<Key, Value> implements SymbolTable<Key, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        private Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    @Override
    public void put(Key key, Value value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }

        if (head == null) {
            head = new Node(key, value);
            return;
        }

        Node prev = null;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            prev = cur;
        }
        prev.next = new Node(key, value);
    }

    @Override
    public void delete(Key key) {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            if (head.key.equals(key)) {
                head = null;
            }
            return;
        }

        Node prev = head;
        for (Node cur = head.next; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                prev.next = cur.next;
                return;
            }
            prev = cur;
        }
    }

    @Override
    public Value get(Key key) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
        }
        return null;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return head != null;
    }

    @Override
    public int size() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
           size++;
        }
        return size;
    }

    @Override
    public Iterator<Key> iterator() {
        return new Iterator<Key>() {
            private Node cur;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Key next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Key key = cur.key;
                cur = cur.next;
                return key;
            }
        };
    }
}
