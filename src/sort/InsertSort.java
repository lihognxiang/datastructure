package sort;

import java.util.Arrays;

/**
 * @Date 2018-09-09
 * @Author lihongxiang
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 7, 1, 4, 8, 6};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int minIndex = i;
                for (int j = i; j > 0 && arr[j - 1] > temp ; j--) {
                    arr[j] = arr[j - 1];
                    minIndex = j;
                }
                arr[minIndex - 1] = temp;
            }
        }
    }
}
