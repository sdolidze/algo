package priority_queue;

/**
 * Created by sandro on 2/16/15.
 */
public interface PriorityQueue<T extends Comparable<T>> extends Iterable<T> {
    public void insert(T elem);

    public T delMax();

    public T max();

    public int size();

    default public boolean isEmpty() {
        return size() == 0;
    }
}
