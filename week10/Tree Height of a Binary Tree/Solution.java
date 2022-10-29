import java.util.Scanner;

public class Solution {
    private static class Node {
        private int data;
        private Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static Node put(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data)
            root.left = put(root.left, data);
        else if (data > root.data)
            root.right = put(root.right, data);
        else if (data == root.data)
            root.data = data;
        return root;
    }

    public static int count(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(count(root.left), count(root.right));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            root = put(root, in.nextInt());
        }

        System.out.println(count(root));

    }
}