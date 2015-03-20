package w121_stacks_and_queues;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * can I leverage dummy object to make this code simpler?
 * code is manageable, but complex
 *
 * to make code manageable I use state machine:
 * size  = 0 => invariant: first == last == null
 * size  = 1 => invariant: first == last != null
 * size >= 2 => invariant: first.next != null && last.prev != null
 */
public class DequeComplex<Item> implements Iterable<Item> {
    private static class Node<T> {
        private T elem;
        private Node<T> prev;
        private Node<T> next;
        Node(T elem) {
            this.elem = elem;
        }
    }

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    public DequeComplex() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        add(item, (newFirst) -> {
            newFirst.next = first;
            first.prev = newFirst;
            first = newFirst;
        });
    }

    public void addLast(Item item) {
        add(item, (newLast) -> {
            last.next = newLast;
            newLast.prev = last;
            last = newLast;
        });
    }

    public Item removeFirst() {
        return remove(() -> first.elem, () -> {
            first = first.next;
            first.prev = null;
        });
    }

    public Item removeLast() {
        return remove(() -> last.elem, () -> {
            last = last.prev;
            last.next = null;
        });
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> head = first;

            @Override
            public boolean hasNext() {
                return head != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item elem = head.elem;
                head = head.next;
                return elem;
            }
        };
    }

    private void add(Item item, Consumer<Node<Item>> adder) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node<Item> node = new Node(item);
        if (size == 0) {
            first = node;
            last = node;
        } else /* size == 1 || size >= 2 */ {
            adder.accept(node);
        }
        size++;
    }

    private Item remove(Supplier<Item> elemSupplier, Runnable remover) {
        if (size == 0) {
            throw new NoSuchElementException("empty deque");
        }
        Item elem = elemSupplier.get();
        if (size == 1) {
            first = null;
            last = null;
        } else /* size >= 2 */ {
            remover.run();
        }
        size--;
        return elem;
    }
}
