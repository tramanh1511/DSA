import javax.swing.plaf.ProgressBarUI;
import java.util.*;

public class Solution {
    public static class Node implements Comparable<Node> {
        private double key;
        private double value;

        public Node(double key, double value) {
            this.key = key;
            this.value = value;
        }

        public double getKey() {
            return key;
        }

        @Override
        public int compareTo(Node other) {
            if (key == other.key) {
                return Double.compare(value, other.value);
            }
            return Double.compare(key, other.key);
        }
    }

    public static List<Double> median(List<Double> arr) {
        List<Double> res = new ArrayList<>();
        TreeSet<Node> treeSet = new TreeSet<>();
        Node runningMedian = new Node(arr.get(0), 0);
        treeSet.add(runningMedian);
        res.add(runningMedian.getKey());

        for (int i = 1; i < arr.size(); i++) {
            Node newNode = new Node(arr.get(i), i);
            treeSet.add(newNode);

            if (treeSet.size() % 2 == 1) {
                if (newNode.compareTo(runningMedian) >= 0) {
                    runningMedian = treeSet.higher(runningMedian);
                }
                res.add(runningMedian.getKey());
            } else {
                if (newNode.compareTo(runningMedian) < 0) {
                    runningMedian = treeSet.lower(runningMedian);
                }
                res.add((runningMedian.getKey() + treeSet.higher(runningMedian).getKey()) / 2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Double> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(in.nextDouble());
        }
        List<Double> res = median(arr);
        for (Double x : res) {
            System.out.println(x);
        }
    }
}