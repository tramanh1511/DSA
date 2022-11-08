import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * The problem states that even if a number is missing more than once, to return it only once.
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(in.nextInt());
        }
        int m = in.nextInt();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            b.add(in.nextInt());
        }

        a.sort(Comparator.naturalOrder());
        b.sort(Comparator.naturalOrder());
        for (int i = 0; i < n; i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < m; i++) {
            System.out.print(b.get(i) + " ");
        }
        System.out.print("\n");

        int i = 0, j = 0;
        while (true) {
            if (a.get(i).equals(b.get(j))) {
                i++;
                j++;
            } else if (b.get(j) < a.get(i)) {
                System.out.print("index " + j + " " + b.get(j) + " ");
                j++;
            } else {
                i++;
            }
            if (i == n) break;
            if (j == m) break;
        }
        if (i == n && j < m) {
            for (; j < m; j++) {
                System.out.print(b.get(j) + " ");
            }
        }
    }
}

