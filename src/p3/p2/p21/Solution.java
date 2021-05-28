package p3.p2.p21;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val)
            head = head.next;
//            while (head != null && head.val == val) {
//                ListNode delNode = head;
//                head = head.next;
//                delNode.next = null;
//            }

        if (head == null)
            return head;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
//        while (prev.next != null) {
//            if (prev.next.val == val) {
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
//            } else
//                prev = prev.next;
//        }
        return head;
    }
}