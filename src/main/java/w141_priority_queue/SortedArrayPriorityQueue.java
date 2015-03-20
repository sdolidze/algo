package w141_priority_queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sandro on 2/16/15.
 */
public class SortedArrayPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private T[] arr;
    private int size;

    public SortedArrayPriorityQueue(int capacity) {
        arr = (T[]) new Comparable[capacity];
    }

    @Override
    public void insert(T elem) {
        int pos = find(elem);
        insert(pos, elem);
        size++;
    }

    private int find(T elem) {
        for (int i = 0; i < size; i++) {
            if (arr[i].compareTo(elem) > 0) {
                return i;
            }
        }
        return size;
    }

    private void insert(int pos, T elem) {
        //System.arraycopy(arr, pos, arr, pos + 1, size - pos);
        for (int i = size; i >= pos + 1; i--) {
            arr[i] = arr[i-1];
        }
        arr[pos] = elem;
    }

    @Override
    public T delMax() {
        T max = arr[size - 1];
        arr[size - 1] = null;
        size--;
        return max;
    }

    @Override
    public T max() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return arr[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cur = 0;

            @Override
            public boolean hasNext() {
                return cur < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arr[cur++];
            }
        };
    }
}
