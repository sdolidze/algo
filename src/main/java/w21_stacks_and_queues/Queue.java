package w21_stacks_and_queues;

/**
 * Created by sandro on 1/31/15.
 */
public interface Queue<T> extends Iterable<T> {
    public void enqueue(T elem);

    public T dequeue();

    public T peek();

    public int size();

    default public boolean isEmpty() {
        return size() == 0;
    }
}
