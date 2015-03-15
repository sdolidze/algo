package w41_priority_queue;

/**
 * This approach is very inefficient, bottom up is way better.
 * This class is very procedural, but I like it :)
 * Not everything has to be OO all the time :)
 */
public class TopToBottomHeapSort {
    public static int[] sort(int[] arr) {
        int[] heap = buildHeap(arr);
        int size = arr.length;

        while (size > 0) {
            // swap(1, size);
            arr[size - 1] = heap[1];
            heap[1] = heap[size];

            size--;
            sink(heap, 1, size);
        }

        return arr;
    }

    private static int[] buildHeap(int[] arr) {
        int[] heap = new int[arr.length + 1];
        int size = 0;

        for (int num : arr) {
            heap[size + 1] = num;
            size++;
            swim(heap, size, size);
        }

        return heap;
    }

    public static void swim(int[] heap, int k, int size) {
        while (k > 1 && heap[k/2] < heap[k]) {
            swap(heap, k, k/2);
            k = k/2;
        }
    }

    public static void sink(int[] heap, int k, int size) {
        while (k * 2 <= size) {
            int maxChild = k * 2;
            if (maxChild + 1 <= size && heap[maxChild + 1] > heap[maxChild]) {
                maxChild++;
            }
            if (heap[maxChild] <= heap[k]) {
                break;
            }
            swap(heap, k, maxChild);
            k = maxChild;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
