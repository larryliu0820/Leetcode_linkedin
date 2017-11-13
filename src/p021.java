/**
 * Created by mengwliu on 11/11/17
 * 21. Merge Two Sorted Lists
 */
public class p021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode smaller = l1.val < l2.val?l1:l2;
        ListNode larger = l1.val < l2.val?l2:l1;
        smaller.next = mergeTwoLists(larger, smaller.next);
        return smaller;
    }
}
