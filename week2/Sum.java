import edu.princeton.cs.algs4.*;
import java.util.Arrays;
import java.util.Date;

public class Sum {
    public static void check(int[] a) {
        for(int i = 0; i < a.length-1; i++)
            for(int j = i+1; j < a.length; j++)
                if(a[i] == -a[j]) {
                    StdOut.println(a[i] + " " + a[j]);
                }
    }

    /**
     * Cach 2: (O(nlogn)).
     */
    public static void TwoSum(int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            int k = Arrays.binarySearch(a, i+1, a.length -1, -a[i]);
            if ( k > 0 && k < a.length) {
                StdOut.println(a[i] + " " + -a[i]);
            }
        }
    }

    /**
     * Cach 3: O(n)
     */
    public static void TwoSum1(int[] a) {
        Arrays.sort(a);
        int sum = 0;
        int i = 0;
        int j = a.length - 1;
        while (i < j && i < a.length && j >= 0) {
            sum = a[i] + a[j];
            if (sum == 0) {
                StdOut.println(a[i] + " " + a[j]);
                i++;
            } else if (sum < 0) {
                i++;
            }
            else {
                j--;
            }
        }
    }

    public static void main(String[] args) {
        In in = new In("E:\\Java\\algs4-data\\algs4-data\\t.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a
        Date d = new Date();
        long s_time = d.getTime();
        // xử lý dữ liệu trong mảng a
        TwoSum1(a);
        // in mảng ra màn hình
        // StdArrayIO.print(a);
        System.out.println((new Date()).getTime() - s_time);


    }
}
