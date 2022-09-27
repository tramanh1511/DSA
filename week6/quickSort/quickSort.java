import edu.princeton.cs.algs4.*;

import java.util.Scanner;

public class quickSort {

    private static int partiton(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            
            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    public static void quickSort(Comparable[] a, int lo, int hi) {
        if (lo > hi) return;
        int j = partiton(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    public static void quickSort(Comparable[] a) {
        StdRandom.shuffle(a);
        quickSort(a, 0, a.length - 1);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.print('\n');
    }

    public static void main(String[] args) {
        // Nhap du lieu tu file
        In in = new In("E:\\Java\\algs4-data\\algs4-data\\4Kints.txt");
        int[] arr = in.readAllInts();

        int n = arr.length;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = arr[i];
        // Do thoi gian chuong trinh chay
        long start = System.currentTimeMillis();
        Merge.sort(a);
        long end = System.currentTimeMillis();

        show(a);
        StdOut.println(end - start);
    }
}
