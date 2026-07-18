class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class SeparateOddEven {

    public static Node separateOddEven(Node head) {
        Node oddDummy = new Node(0);
        Node evenDummy = new Node(0);

        Node odd = oddDummy;
        Node even = evenDummy;
        Node curr = head;

        while (curr != null) {
            if (curr.data % 2 != 0) {
                odd.next = curr;
                odd = odd.next;
            } else {
                even.next = curr;
                even = even.next;
            }
            curr = curr.next;
        }

        even.next = null;
        odd.next = evenDummy.next;

        return oddDummy.next;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head = separateOddEven(head);
        printList(head);
    }
}
