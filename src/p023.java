import java.util.PriorityQueue;

/**
 * Created by Larry Liu on 11/15/2017.
 * 23. Merge k Sorted Lists
 */
public class p023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->a.val-b.val);
        for (ListNode node: lists) {
            if (node != null) pq.offer(node);
        }
        ListNode head = pq.peek();
        ListNode itr = new ListNode(0);
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            itr.next = curr;
            if (curr.next != null) pq.offer(curr.next);
            itr = itr.next;
        }
        return head;
    }
}
