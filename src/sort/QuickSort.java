package sort;

import java.util.Arrays;

/**
 * @Date 2018-08-20
 * @Author lihongxiang
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arrOne = new int[]{2, 5, 3, 7, 1, 4, 8, 6};
        quickSortOne(arrOne, 0, arrOne.length - 1);
        System.out.println(" sortOne:" + Arrays.toString(arrOne));

        int[] arrTwo = new int[]{2, 5, 3, 7, 1, 4, 8, 6};
        quickSortTwo(arrTwo, 0, arrTwo.length - 1);
        System.out.println(" sortTwo:" + Arrays.toString(arrTwo));

    }


    /**
     * 指针交换法
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSortOne(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        if (i > j) {
            return;
        }
        int key = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= key) {
                j--;
            }
            while (i < j && arr[i] <= key) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;
        quickSortOne(arr, left, i - 1);
        quickSortOne(arr, i + 1, right);
    }

    /**
     * 挖坑法
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    private static void quickSortTwo(int[] arr, int startIndex, int endIndex) {
        int i = startIndex;
        int j = endIndex;
        int index = startIndex;
        if (i > j) {
            return;
        }
        int key = arr[startIndex];
        while (i < j) {
            while (i < j) {
                if (arr[j] < key) {
                    arr[i] = arr[j];
                    index = j;
                    i++;
                    break;
                }
                j--;
            }
            while (i < j) {
                if (arr[i] > key) {
                    arr[j] = arr[i];
                    index = i;
                    j--;
                    break;
                }
                i++;
            }
        }
        arr[index] = key;
        quickSortTwo(arr, startIndex, index - 1);
        quickSortTwo(arr, index + 1, endIndex);
    }
}
