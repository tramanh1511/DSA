import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PQ {
    public static class MaxPQ<Key extends Comparable<Key>> {
        private Key[] pq;
        private int n;

        public MaxPQ() {

        }

        public MaxPQ(int capacity) {
            pq = (Key[]) new Comparable[capacity + 1];
        }


        public int size() {
            return n;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public void insert(Key key) {
            pq[++n] = key;
            swim(n);
        }

        public void swim(int k) {
            // Trong khi k chưa là root và node cha < node con
            while (k > 1 && less(k / 2, k)) {
                exch(k / 2, k);
                k = k / 2;
            }
        }

        public void sink(int k) {
            // Trong khi k vẫn còn node con
            while (2 * k <= n) {
                int j = 2 * k;
                // Xem node trái hay phải lớn hơn
                if (j < n && less(j, j + 1)) j++;
                // Nếu node cha ko nhỏ hơn node con thì break
                if (!less(k, j)) break;
                exch(k, j);
                k = j;
            }
        }

        public Key delMax() {
            // root là node max
            Key max = pq[1];
            exch(1, n--);
            sink(1);
            pq[n + 1] = null;
            return max;
        }


        private boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }

        private void exch(int i, int j) {
            Key temp = pq[i];
            pq[i] = pq[j];
            pq[j] = temp;
        }
    }

    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<Integer>(5);
        while (!StdIn.isEmpty()) {
            Integer item = StdIn.readInt();
            if (!item.equals(0)) pq.insert(item);
            else if (!pq.isEmpty()) StdOut.print(pq.delMax() + " ");
        }
        StdOut.println("(" + pq.size() + " left on pq)");
    }
}

