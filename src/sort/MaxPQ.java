package sort;

import java.util.Arrays;

/**
 * @Date 2018-09-09
 * @Author lihongxiang
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;

    private int n = 0;

    public MaxPQ(Key[] arr) {
        Key[] keys = (Key[]) new Comparable[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            keys[i + 1] = arr[i];
        }
        this.pq = keys;
        n = arr.length;
    }

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN  +1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Key v) {
        pq[++n] = v;
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k/2, k);
            k = k / 2;
        }
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, n --);
        pq[n + 1] = null;
        sink(1);
        return max;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j ++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int k, int j) {
        return pq[k].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"b", "a", "e", "f", "c", "n", "x", "y", "m", "p", "d"};
        MaxPQ maxPQ = new MaxPQ(arr.length);
        for (String anArr : arr) {
            maxPQ.insert(anArr);
        }
        System.out.println(Arrays.toString(maxPQ.pq));
        while (maxPQ.n > 0) {
            System.out.print(maxPQ.delMax() + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(maxPQ.pq));

    }
}
