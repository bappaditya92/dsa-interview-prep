import java.util.PriorityQueue;

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>(
                        (a, b) -> a.val - b.val
                );

        for(ListNode node : lists) {

            if(node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        while(!pq.isEmpty()) {

            ListNode node = pq.poll();

            current.next = node;

            current = current.next;

            if(node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}
