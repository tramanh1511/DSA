import edu.princeton.cs.algs4.*;


public class mergeSort {
    private static void Merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // Copy array
        for (int i = lo; i < hi; i++) {
            aux[i] = a[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k < hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
       // return v < w;
        return v.compareTo(w) < 0;
    }

    /**
     * no inplace
     * stable phụ thuộc
     * Độ phức tạp: T(n) = 2*T(n/2) + c1*n = 2*(2*T(n/4) + c1*n/2) + c1*n = ....
     *                   = 2^i * T(n/(2^i)) + i*c1*n
     *              2^i = n => i = logn
     *              T(n) = n +
     */
    public static void merge_sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        merge_sort(a, aux, lo, mid); // T(n/2)
        merge_sort(a, aux, mid + 1, hi); // T(n/2)
        Merge(a, aux, lo, mid, hi); // c1.n
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        merge_sort(a, aux, 0, a.length - 1);
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
