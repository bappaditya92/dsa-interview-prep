class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Step 2: Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 3: Move both pointers
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 4: Remove node
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Utility to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next
