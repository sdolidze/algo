package w21_stacks_and_queues;

/**
 * Created by sandro on 1/31/15.
 */
public interface Stack<T> extends Iterable<T> {
    public void push(T elem);

    public T pop();

    public T peek();

    public int size();

    default public boolean isEmpty() {
        return size() == 0;
    }
}
