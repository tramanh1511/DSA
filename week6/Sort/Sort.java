import java.util.Scanner;
import edu.princeton.cs.algs4.*;

public class Sort {



    public static void selectedSort(int[] a) {
        int n = a.length;
        int min = 0;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    /**
     * Inplace: X
     * Chỉ stable khi so sánh (<)
     * Đặc điểm: Tốt khi sx 1 phần (số phần tử nhỏ)
     */
    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) exch(a, j - 1, j);
                else break;
            }
        }
    }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    public static void main(String[] args) {
      /*  Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        insertionSort(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }*/
        In in = new In("E:\\Java\\algs4-data\\algs4-data\\1Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a
        long start = System.currentTimeMillis();
        // xử lý dữ liệu trong mảng a
        insertionSort(a);
        long end = System.currentTimeMillis();  // thời gian chạy bằng end - start
        StdArrayIO.print(a); // in mảng ra màn hình
        StdOut.print("\n");
        StdOut.print( end - start);
    }
}
