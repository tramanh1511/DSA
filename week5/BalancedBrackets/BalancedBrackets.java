import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static class Stack {
        private static Node first = null;
        private class Node {
            char item;
            Node next;
            public Node (char item, Node next) {
                this.item = item;
                this.next = next;
            }
        }

        public Stack() {
            first = null;
        }

        public boolean isEmpty() {
            return (first == null);
        }

        public void push(char item) {
            first = new Node(item, first);
        }

        public static char pop() {
            if (first == null) return '.';
            char item = first.item;
            first = first.next;
            return item;
        }
    }

    public static String isBalanced(String s){
        char temp;
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                temp = Stack.pop();
                if (temp == '.') return "NO";
                if (s.charAt(i) == ')' && temp != '(') return "NO";
                if (s.charAt(i) == ']' && temp != '[') return "NO";
                if (s.charAt(i) == '}' && temp != '{') return "NO";
            }
        }
        if (!stack.isEmpty()) return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            System.out.println(isBalanced(s));
        }
    }
}


