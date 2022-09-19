import java.io.*;
import java.util.stream.IntStream;


public class Solution {
    public static class SList {
        Node head;

        private class Node {
            int data;
            Node next;

            public Node(Node other) {
                this.data = other.data;
                this.next = other.next;
            }

            public Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }
        }

        public void addLast(int data) {
            if (head == null) head = new Node(data, head);
            else {
                Node p = head;
                for (; p.next != null; p = p.next) ;
                p.next = new Node(data, null);
            }
        }

        public SList MergeList(SList other) {
            SList res = new SList();
            Node p1 = new Node(this.head);
            Node p2 = new Node(other.head);
            while (p1 != null && p2 != null) {
                if (p2.data >= p1.data) {
                    res.addLast(p1.data);
                    p1 = p1.next;
                } else {
                    res.addLast(p2.data);
                    p2 = p2.next;
                }
                if (p1 == null && p2 != null) {
                    for (; p2 != null; p2 = p2.next) {
                        res.addLast(p2.data);
                    }
                }
                if (p2 == null && p1 != null) {
                    for (; p1 != null; p1 = p1.next) {
                        res.addLast(p1.data);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, tests).forEach(testsItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                SList s1 = new SList();
                IntStream.range(0, n).forEach(i -> {
                    try {
                        int s1Item = Integer.parseInt(bufferedReader.readLine().trim());
                        s1.addLast(s1Item);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                int m = Integer.parseInt(bufferedReader.readLine().trim());
                SList s2 = new SList();
                IntStream.range(0, m).forEach(i -> {
                    try {
                        int s2Item = Integer.parseInt(bufferedReader.readLine().trim());
                        s2.addLast(s2Item);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                SList res = s1.MergeList(s2);
                for (SList.Node p = res.head; p != null; p = p.next) {
                    bufferedWriter.write(String.valueOf(p.data));
                    bufferedWriter.append(' ');
                }
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        bufferedWriter.close();
    }
}
