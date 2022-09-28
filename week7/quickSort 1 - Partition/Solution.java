import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static List<Integer> partiton(List<Integer> arr) {
        int p = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        for (Integer x : arr) {
            if (x < p) left.add(x);
            else if (x > p) right.add(x);
            else equal.add(x);
        }
        left.addAll(equal);
        left.addAll(right);
        return left;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        List<Integer> res = partiton(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(res.get(i) + " ");
        }
    }

}
