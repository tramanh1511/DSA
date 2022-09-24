import java.util.List;
import java.util.Stack;

public class Solution {

    public static class Stack {
        private static Node first = null;

        private class Node {
            int item;
            Node next;
            public Node(int item, Node next) {
                this.next = next;
                this.item = item;
            }
        }

        public static boolean isEmpty() {
            return first == null;
        }
        public void push(int item) {
            first = new Node(item, first);
        }

        public static int pop() {
            if (isEmpty()) return 0;
            int item = first.item;
            first = first.next;
            return item;
        }
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (Integer integer : h1) {
            stack1.push(integer);
            sum1 += integer;
        }
        for (Integer integer : h2) {
            stack2.push(integer);
            sum2 += integer;
        }
        for (Integer integer : h3) {
            stack3.push(integer);
            sum3 += integer;
        }

        if(sum1 == sum2 && sum2 == sum3) {
            return sum1;
        }

        int min = Math.min(sum1, Math.min(sum2,sum3));
        while (sum1 > min || sum2 > min || sum3 > min) {
            if (sum1 > min) sum1 -= stack1.pop();
            if (sum2 > min) sum2 -= stack2.pop();
            if (sum3 > min) sum3 -= stack3.pop();
            min = Math.min(sum1, Math.min(sum2,sum3));
        }
        return min;
    }

    public static void main(String[] args) {


    }
}
