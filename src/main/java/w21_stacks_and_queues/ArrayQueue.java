package w21_stacks_and_queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * hmm, clever trick, using array as finite field :)
 * invariant: if first % arr.length == last array is either full or empty
 */
public class ArrayQueue<T> implements Queue<T> {
    private T[] arr;
    private int first; // index of first element of queue
    private int last; // index of next available slot
    private int size;

    public ArrayQueue() {
        arr = (T[]) new Object[2];
        first = 0;
        last = 0;
        size = 0;
    }

    @Override
    public void enqueue(T elem) {
        if (elem  == null) {
            throw new NullPointerException();
        }
        if (size == arr.length) {
            resize(size * 2);
        }
        arr[last] = elem;
        last = (last + 1) % arr.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T elem = arr[first];
        arr[first] = null;
        size--;
        first = (first + 1) % arr.length;
        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
        return elem;
    }

    @Override
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return arr[first];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arr[(first + pos++) % arr.length];
            }
        };
    }

    private void resize(int newSize) {
        T[] newArr = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(first + i) % arr.length];
        }
        arr = newArr;
        first = 0;
        last = size;
    }
}
