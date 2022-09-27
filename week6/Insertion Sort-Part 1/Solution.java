import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        for (int i = n - 1; i > 0; i--) {
            int temp = arr.get(i);
            if (arr.get(i - 1) > temp) {
                arr.set(i, arr.get(i - 1));
                printArray(n, arr);
                arr.set(i - 1, temp);
            }
        }
        printArray(n, arr);
    }

    private static void printArray(int n, List<Integer> arr) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> a = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++) {
            a.add(i, in.nextInt());
        }
        insertionSort1(a.size(), a);


    }

}
