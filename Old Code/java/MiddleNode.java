class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class MiddleNode {

    public static Node findMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
