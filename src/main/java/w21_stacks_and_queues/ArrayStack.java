package w21_stacks_and_queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sandro on 1/31/15.
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] xs;
    private int size;

    public ArrayStack() {
        xs = (T[]) new Object[2];
        size = 0;
    }

    @Override
    public void push(T elem) {
        if (size == xs.length) {
            resize(size * 2);
        }

        xs[size++] = elem;
    }

    @Override
    public T pop() {
        if (size  == 0) {
            throw new RuntimeException("empty stack");
        }
        T temp = xs[size - 1];
        xs[size - 1] = null;
        size--;
        // avoid thrashing, invariant: array is between 25% and 100% full
        if (size > 0 && size == xs.length / 4) {
            resize(xs.length / 2);
        }
        return temp;
    }

    @Override
    public T peek() {
        return xs[size-1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = size - 1;

            @Override
            public boolean hasNext() {
                return pos >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("empty stack");
                }
                return xs[pos--];
            }
        };
    }

    private void resize(int newSize) {
        T[] newArr = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArr[i] = xs[i];
        }
        xs = newArr;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.forEach(System.out::println);
    }
}
