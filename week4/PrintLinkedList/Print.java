import java.util.*;
public class Print {
    public class SinglyLinkedList {
        private class Node {
            int data;
            Node next;
            public Node(int data, Node next){
                this.data = data;
                this.next = next;
            }
        }
        Node head;
        public void Print(){
            for(Node p = head; p!= null; p = p.next){
                System.out.println(p.data);
            }
    }

    public static void main(String[] args) {
            int n;
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            for(int i = 0; i < n; i++){
                int temp = sc.nextInt();

            }

    }


    }
}
