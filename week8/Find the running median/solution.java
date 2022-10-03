import java.util.*;

public class solution {
    public static List<Double> runningMedian(List<Integer> arr) {
        // Write your code here
        List<Double> res = new ArrayList<>();
        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Comparator.reverseOrder());

        res.add((double) arr.get(0));
        maxPQ.add(arr.get(0));

        for (int i = 1; i < arr.size(); i++) {
            int temp = arr.get(i);
            if (temp > maxPQ.peek()) {
                minPQ.add(temp);
            } else {
                maxPQ.add(temp);
                if (minPQ.isEmpty()) minPQ.add(maxPQ.remove());
                else {
                    if (maxPQ.peek() > minPQ.peek()) {
                        minPQ.add(maxPQ.remove());
                    }
                }
            }

            if (minPQ.size() - maxPQ.size() > 1) {
                maxPQ.add(minPQ.remove());
            } else if (maxPQ.size() - minPQ.size() > 1) {
                minPQ.add(maxPQ.remove());
            }

            if (maxPQ.size() > minPQ.size()) {
                res.add((double) maxPQ.peek());
            } else if (maxPQ.size() < minPQ.size()) {
                res.add((double) minPQ.peek());
            } else {
                res.add((double) (maxPQ.peek() + minPQ.peek()) / 2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();

        List<Integer> arr = new ArrayList<Integer>(N);
        for (int i = 0; i < N; i++) {
            arr.add(in.nextInt());
        }

        List<Double> res = runningMedian(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.printf("%.1f\n", res.get(i));
        }
    }
}
