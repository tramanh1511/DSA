import java.util.*;

public class Pairs {
    public static int count_pairs(int k, List<Integer> arr) {
        int count = 0;
        Set<Integer> set = new HashSet<>(arr);
        for (Integer x : arr) {
            if (set.contains(x + k)) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        System.out.println(count_pairs(k, arr));

    }
}