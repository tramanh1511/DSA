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

    public static Node put(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data)
            root.left = put(root.left, data);
        else if (data > root.data)
            root.right = put(root.right, data);
        else if (data == root.data)
            root.data = data;
        return root;
    }

    public static Node LCA(Node root, int v1, int v2) {
        if (root == null) return null;
        if (root.data > v1 && root.data > v2)
            return LCA(root.left, v1, v2);
        if (root.data < v1 && root.data < v2)
            return LCA(root.right, v1, v2);
        return root;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            root = put(root, in.nextInt());
        }

        int v1 = in.nextInt();
        int v2 = in.nextInt();

        System.out.println(LCA(root, v1, v2).data);
    }
}