import java.util.List;

public class SList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst("First");
        list.addLast("Two");
        list.addFirst("First");
        list.addLast("Five");
        list.insert("Three", 3);
        list.addLast("Six");
        list.addLast("Six");
        list.addLast("Six");
        list.Print();

       // list.reversePrint(list.head);
       // list.removeDuplicate(list.head);
       // list.deleteNode(list.head, 0);
        list.reverse(list.head);
        list.Print();
    }
}
