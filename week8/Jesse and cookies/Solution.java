import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static class MinPQ<Key extends Comparable<Key>> {
        private Key[] pq;
        private int n;

        public MinPQ(int capacity) {
            pq = (Key[]) new Comparable[capacity + 1];
        }

        public int size() {
            return n;
        }

        public void insert(Key key) {
            pq[++n] = key;
            swim(n);
        }

        public void swim(int k) {
            while (k > 1 && greater(k / 2, k)) {
                exch(k / 2, k);
                k = k / 2;
            }
        }

        public void sink(int k) {
            while (2 * k <= n) {
                int j = 2 * k;
                if (j < n && greater(j, j + 1)) j++;
                if (!greater(k, j)) break;
                exch(k, j);
                k = j;
            }
        }

        public Key delMin() {
            Key min = pq[1];
            exch(1, n--);
            sink(1);
            pq[n + 1] = null;
            return min;
        }

        public Key Min() {
           return pq[1];
        }

        private boolean greater(int i, int j) {
            return pq[i].compareTo(pq[j]) > 0;
        }

        private void exch(int i, int j) {
            Key temp = pq[i];
            pq[i] = pq[j];
            pq[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        Integer K;
        N = scanner.nextInt();
        K = scanner.nextInt();

        MinPQ<Integer> pqueue = new MinPQ<Integer>(N);
        for (int i = 0; i < N; i++) {
            pqueue.insert(scanner.nextInt());
        }

        int cnt = 0;
        while (pqueue.size() > 1 && pqueue.Min() < K) {
           int min1 = pqueue.delMin();
           int min2 = pqueue.delMin();
           int combine = min1 + 2 * min2;
           pqueue.insert(combine);
           cnt++;
        }
        if (pqueue.size() < 2 && pqueue.Min() < K) System.out.println(-1);
        else System.out.println(cnt);
    }
}
