package sort;

import java.util.Arrays;

/**
 * @Date 2018-09-10
 * @Author lihongxiang
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 7, 1, 4, 8, 6, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        int n = arr.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            sink(arr, i, n);
        }
        while (n >= 0) {
            exch(arr, 0, n--);
            sink(arr, 0, n);
        }

    }

    private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sink(int[] arr, int k, int n) {
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            if (j < n && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[k] > arr[j]) {
                break;
            }
            exch(arr, k, j);
            k = j;
        }
    }
}
