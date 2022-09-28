import java.io.IOException;
import java.util.Scanner;


public class solution {
    public static int partition(Comparable[] arr, int lo, int hi) {
        Comparable pivot = arr[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (less(arr[j], pivot)) {
                exch(arr, j , i);
                i++;
            }
        }
        exch(arr, i, hi);
        return i;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] arr, int j, int i) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(arr, lo, hi);
        show(arr);
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);
    }

    public static void quickSort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void show(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        quickSort(arr);
    }

}
