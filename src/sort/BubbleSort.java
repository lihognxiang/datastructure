package sort;

import java.util.Arrays;

/**
 * @Date 2018-08-20
 * @Author lihongxiang
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 7, 1, 4, 8, 6};
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean circle = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    circle = true;
                }
            }
            if (!circle) {
                break;
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
