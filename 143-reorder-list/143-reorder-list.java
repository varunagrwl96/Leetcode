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
    public void reorderList(ListNode head) {
        ListNode head2 = head;
        
        //Find middle node
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        //reverse linked list
        ListNode revtemp = null;
        ListNode prev=null;
        while(slow!=null){
            revtemp = slow.next;
            slow.next=prev;
            prev=slow;
            slow=revtemp;
        }
        ListNode revhead = prev;
        
        while(revhead.next!=null){
            ListNode tmp = head2.next;
            head2.next=revhead;
            head2=tmp;
            
            ListNode tmp2 = revhead.next;
            revhead.next=head2;
            revhead=tmp2;
        }
    }
}

//O(N)
//O(1)