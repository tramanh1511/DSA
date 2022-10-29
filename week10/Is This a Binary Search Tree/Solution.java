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
        return root;
    }

    public static boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBST(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data < min || root.data > max) return false;
        return checkBST(root.left, min, root.data - 1)
                && checkBST(root.right, root.data + 1, max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            root = put(root, in.nextInt());
        }

        if (checkBST(root)) System.out.println("Yes");
        else System.out.println("No");
    }
}