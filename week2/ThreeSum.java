import edu.princeton.cs.algs4.*;
import java.util.Arrays;
import java.util.Date;

public class ThreeSum {
    public static void check(int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++)
            for (int j = i+1; j < a.length - 1; j++){
                int k = Arrays.binarySearch(a, j+1, a.length, -(a[i]+a[j]));
                if(k > 0 && k < a.length) {
                  //  StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                }
            }
    }

    /**
     * Cach 2: O(N)
     */
    public static void ThreeSum1(int[] a) {
        Arrays.sort(a);
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int j = i + 1;
            int k = a.length -1;
            while (j < k) {
                sum = a[i] + a[j] + a[k];
                if (sum == 0) {
                    StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    j++;
                } else if (sum < 0) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        In in = new In("E:\\Java\\BT\\Test\\t.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a
        Date d = new Date();
        long s_time = d.getTime();
        // xử lý dữ liệu trong mảng a
        System.out.println("Cach 1");
        check(a);
        System.out.println((new Date()).getTime() - s_time);
     //   StdArrayIO.print(a); // in mảng ra màn hình
        System.out.println("Cach 2");
        ThreeSum1(a);
        System.out.println((new Date()).getTime() - s_time);

    }
}
