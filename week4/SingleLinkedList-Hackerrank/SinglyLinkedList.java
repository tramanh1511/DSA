import java.text.CollationElementIterator;

public class SinglyLinkedList {
    private class Node {
        String data;
        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Node other) {
            this.data = other.data;
            this.next = other.next;
        }
    }

    Node head;

    public void addFirst(String data) {
        head = new Node(data, head);
    }

    public void addLast(String data) {
        /*if(head == null){
            addFirst(data);
            return;
        }
        Node lastNode = head;
        for(;lastNode.next != null; lastNode = lastNode.next);
        lastNode.next = new Node(data, null);*/
        head = addLast(data, head);
    }

    private Node addLast(String data, Node start) {
        if (start != null) {
            start.next = addLast(data, start.next);
            return start;
        } else {
            return new Node(data, null);
        }
    }

    public void Print() {
        System.out.print("[");
      /*  for(Node p = head; p != null; p = p.next){
            System.out.print(p.data + ", ");
        }*/
        // dung de quy
        Print(head);
        System.out.println("]");
    }

    private void Print(Node start) {
        if (start == null) return;
        System.out.print(start.data + ", ");
        Print(start.next);
    }

    public void insert(String data, int pos) {
        if (pos == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data, null);
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        Node oldNode = temp.next;
        temp.next = newNode;
        newNode.next = oldNode;
    }

    public void reversePrint(Node head) {
        if (head == null) return;
        reversePrint(head.next);
        System.out.println(head.data);
    }

    public Node removeDuplicate(Node head) {
        if (head == null) return null;
        for (Node p = head; p.next != null; ) {
            Node temp = p.next;
            if ((temp.data).equals(p.data)) {
                p.next = temp.next;
            } else p = p.next;
        }
        return head;
    }

    public Node deleteNode(Node head, int pos) {
        if (pos == 0) {
            head = head.next;
            return head;
        }
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public Node reverse(Node head) {
        Node pre = null;
        Node cur = head;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;
        return head;
    }




}
