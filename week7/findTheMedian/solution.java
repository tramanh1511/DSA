import java.util.Scanner;

public class solution {
    public static int partition(Comparable[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable pivot = arr[lo];
        while (true) {
            while (less(arr[++i], pivot)) {
                if (i == hi) break;
            }

            while (less(pivot, arr[--j])) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exch(arr, i, j);
        }
        exch(arr, lo, j);
        return j;
    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static Comparable findMedian(Comparable[] arr, int lo, int hi) {
        int n = arr.length;
       if (lo <= hi) {
            int p = partition(arr, lo, hi);
            if (p == n/2) {
                return arr[p];
            }
            else if (p > n/2) {
                return findMedian(arr, lo, p - 1);
            }
           return findMedian(arr, p + 1, hi);
        }
        return -1;
    }

    public static Comparable findMedian(Comparable[] arr) {
        return findMedian(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            arr[i] = a[i];
        }
      //  findMedian(arr);
        System.out.println(findMedian(arr));


    }
}
