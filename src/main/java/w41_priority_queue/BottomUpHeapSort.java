package w41_priority_queue;

/**
 * Created by sandro on 2/18/15.
 */
public class BottomUpHeapSort {
    public static int[] sort(int[] heap) {
        int size = heap.length;

        for (int i = size / 2; i >= 1; i--) {
            sink(heap, i, size);
        }

        while (size > 1) {
            swap(heap, 1, size);
            size--;
            sink(heap, 1, size);
        }

        return heap;
    }

    private static void sink(int[] heap, int parent, int size) {
        while (parent * 2 <= size) {
            int maxChild = parent * 2;
            if (maxChild + 1 <= size && less(heap, maxChild, maxChild + 1)) {
                maxChild++;
            }
            if (!less(heap, parent, maxChild)) {
                break;
            }
            swap(heap, parent, maxChild);
            parent = maxChild;
        }
    }

    // i, j are [1, heap.length]
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = temp;
    }

    // heap[i] < heap[j] ? i, j are [1, heap.length]
    private static boolean less(int[] heap, int i, int j) {
        return heap[i-1] < heap[j-1];
    }
}
