package analysis_of_algorithms;

import java.util.Arrays;

public class ThreeSum {
    public static boolean isSorted(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            if (arr[i-1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static int twoSum(int[] arr, int sum, int i) {
        assert isSorted(arr);

        int count = 0;
        int j = arr.length - 1;

        while (i < j) {
            int res = arr[i] + arr[j];
            if (res < sum) {
                i++;
            } else if (res > sum) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }

        return count;
    }

    public static int threeSumDecomposed(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i=0; i<arr.length-2; i++) {
            count += twoSum(arr, -arr[i], i+1);
        }
        return count;
    }

    public static int threeSumCubic(int[] arr) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                for (int k=j+1; k<arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int threeSumQuadratic(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i=0; i<arr.length-2; i++) {
            int j = i+1;
            int k = arr.length-1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    count++;
                    j++;
                }
            }
        }
        return count;
    }

    public static int[] remove(int[] arr, int indexToSkip) {
        int[] newArr = new int[arr.length-1];
        int j = 0;
        for (int i=0; i<arr.length; i++) {
            if (i != indexToSkip) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,2,3};
        System.out.println("he");
        System.out.println(threeSumQuadratic(new int[]{0, 0, 0, 0}));  // outputs: 2
        System.out.println(threeSumCubic(new int[]{0, 0, 0, 0})); // outputs: 4
    }

}
