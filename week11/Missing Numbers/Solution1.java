import java.util.*;

public class Solution1 {
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

        Map<Integer, Integer> map1 = new TreeMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();

        for (Integer key : a) {
            if (map1.containsKey(key)) {
                map1.put(key, map1.get(key) + 1);
            } else {
                map1.put(key, 1);
            }
        }

        for (Integer key : b) {
            if (map2.containsKey(key)) {
                map2.put(key, map2.get(key) + 1);
            } else {
                map2.put(key, 1);
            }
        }

        for (Integer key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                System.out.print(key + " ");
            }
            else if (map1.get(key) < map2.get(key)) {
                System.out.print(key + " ");
            }
        }
    }
}