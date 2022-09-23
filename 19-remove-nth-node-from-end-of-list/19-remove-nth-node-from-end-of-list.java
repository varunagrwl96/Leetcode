/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode ahead=dummy;
        ListNode back=dummy;
        while(n>0){
            ahead=ahead.next;
            n--;
        }
        ListNode prev=back;
        while(ahead!=null){
            ahead=ahead.next;
            prev=back;
            back=back.next;
        }
        prev.next=back.next;
        return dummy.next;
    }
}