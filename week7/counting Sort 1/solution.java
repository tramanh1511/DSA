import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class solution {
    /**
     * HashMap
     */
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer key:arr) {
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        for (int i = 0; i < 100; i++) {
            if (hashMap.containsKey(i)) {
                result.add(hashMap.get(i));
            } else {
                result.add(0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        List<Integer> res = countingSort(arr);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
