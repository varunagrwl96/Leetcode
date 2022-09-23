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
        ListNode headtemp=head;
        ListNode ans = head;
        while(head!=null){
            count++;
            head=head.next;
        }
        // if(n==1 && count==1) return null;
        if(count==n) return ans.next;
        int remove = count-n;
        ListNode prev=headtemp;
        while(remove>0){
            remove--;
            prev=headtemp;
            headtemp=headtemp.next;
        }
        prev.next=headtemp.next;
        return ans;
    }
}