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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev=new ListNode(-1);
        ListNode prevhead=prev;
        prev.next=head;
        while(head!=null){
            if(head.val==val){
                prev.next=head.next;
                head=head.next;
            }else{
                prev=head;
                head=head.next;
            }
        }
        return prevhead.next;
    }
}