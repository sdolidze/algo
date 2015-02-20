package stacks_and_queues;

/**
 * Created by sandro on 2/2/15.
 */
public class JavaGenerics {
    private static class Generic<T> {
        private T[] arr;

        public Generic(T[] arr) {
            this.arr = arr;
        }

        public T[] getArray() {
            return arr;
        }

        public void doSomething() {
            arr = (T[]) new Object[5];
        }
    }

    public static void main(String[] args) {
        Generic<String> foo = new Generic<>(new String[2]);
        foo.doSomething();
        String[] bar = foo.getArray(); // ClassCastException here, because generics puts cast to String[]
    }
}
