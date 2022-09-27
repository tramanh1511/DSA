import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr.get(j) < arr.get(j-1)) {
                    swap(j, j - 1, arr);
                }
            }
        }
        printArray(n, arr);
    }

    private static void printArray(int n, List<Integer> arr) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    private static void swap(int i, int j, List<Integer> arr) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        insertionSort2(n, arr);
    }
}
