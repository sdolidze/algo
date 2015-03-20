package w131_mergesort;

/**
 * Created by sandro on 2/10/15.
 */
public class Inversions {
    public static int inversionsQuadratic(int[] arr) {
        int inversions = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }

    public static int inversionsLinearithmic(int[] arr) {
        return inversions(arr, new int[arr.length], 0, arr. length - 1);
    }

    private static int inversions(int[] arr, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }

        int mid = (lo + hi) / 2;
        return inversions(arr, aux, lo, mid) + inversions(arr, aux, mid + 1, hi) + merge(arr, aux, lo, mid, hi);
    }

    private static int merge(int[] arr, int[] aux, int lo, int mid, int hi) {
        int inversions = 0;

        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }

        int left = lo;
        int right = mid + 1;

        for (int i = lo; i <= hi; i++) {
            if (left > mid) {
                arr[i] = aux[right++];
            } else if (right > hi) {
                arr[i] = aux[left++];
            } else if (aux[left] > aux[right]) {
                arr[i] = aux[right++];
                inversions += mid - left + 1;
            } else {
                arr[i] = aux[left++];
            }
        }

        return inversions;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 2, 3};
        System.out.println(inversionsQuadratic(arr));
        System.out.println(inversionsLinearithmic(arr));

        System.out.println();

        arr = new int[] {3, 2, 1, 0};
        System.out.println(inversionsQuadratic(arr));
        System.out.println(inversionsLinearithmic(arr));
    }

}