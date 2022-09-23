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
        int count=0;
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        while(head!=null){
            count++;
            head=head.next;
        }
        // if(count==n) return ans.next;
        int remove = count-n;
        ListNode headtemp=dummy.next;
        ListNode prev=dummy;
        while(remove>0){
            remove--;
            prev=headtemp;
            headtemp=headtemp.next;
        }
        prev.next=headtemp.next;
        return dummy.next;
    }
}