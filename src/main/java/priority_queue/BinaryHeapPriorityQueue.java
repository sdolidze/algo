package priority_queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 */
public class BinaryHeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private T[] arr;
    private int size;

    public BinaryHeapPriorityQueue(int capacity) {
        arr = (T[]) new Comparable[capacity + 1];
        size = 0;
    }

    @Override
    public void insert(T elem) {
        arr[size + 1] = elem;
        swim(size + 1);
        size++;
    }

    private void swim(int child) {
        while (child > 1 && less(child/2, child)) {
            swap(child, child/2);
            child /= 2;
        }
    }

    private void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public T delMax() {
        T max = arr[1];
        arr[1] = arr[size];
        arr[size] = null;
        size--;
        sink(1);
        return max;
    }

    private void sink(int parent) {
        // I call maxChild multiple times, but code is simpler
        while (2 * parent <= size && less(parent, maxChild(parent))) { // we use "<=" because indexing start at 1, not 0
            swap(parent, maxChild(parent));
            parent = maxChild(parent);
        }

//        while (2*k <= size) { // we use "<=" because indexing start at 1, not 0
//            int maxChild = maxChild(k);
//            if (!less(k, maxChild)) {
//                break;
//            }
//            swap(k, maxChild);
//            k = maxChild;
//        }
    }

    private boolean less(int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private int maxChild(int k) {
        int j = 2 * k;
        if (j < size && less(j, j + 1)) {
            return j + 1;
        } else {
            return j;
        }
    }

    @Override
    public T max() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return arr[1]; // largest element in heap
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = 1;

            @Override
            public boolean hasNext() {
                return pos <= size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arr[pos++];
            }
        };
    }
}
