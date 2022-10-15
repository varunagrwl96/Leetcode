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
    public boolean isPalindrome(ListNode head) {
        //findmiddle
        //reverse second half
        //check
        int count=0;
        ListNode head1=head;
        ListNode head2=head;
        while(head1!=null){
            count++;
            head1=head1.next;
        }
        int middle=0;
        if(count%2!=0){
            middle = count/2 +1;
        }else{
            middle = count/2;
        }
        int x=0;
        while(x<middle){
            x++;
            head2=head2.next;
        }

        ListNode revhead = reverse(head2);
        while(revhead!=null){
            if(head.val!=revhead.val){
                return false;
            }
            head=head.next;
            revhead=revhead.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
}