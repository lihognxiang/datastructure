package sort;

import java.util.Arrays;

/**
 * @Date 2018-09-09
 * @Author lihongxiang
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 7, 1, 4, 8, 6};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    int temp = arr[j - h];
                    arr[j - h] = arr[j];
                    arr[j] = temp;
                }
            }
            h = h / 3;
        }
    }
}
