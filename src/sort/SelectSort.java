package sort;

import sun.java2d.pipe.AAShapePipe;

import java.util.Arrays;

/**
 * @Date 2018-09-09
 * @Author lihongxiang
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 7, 1, 4, 8, 6};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int minValue = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = minValue;
            arr[minIndex] = temp;
        }
    }
}
