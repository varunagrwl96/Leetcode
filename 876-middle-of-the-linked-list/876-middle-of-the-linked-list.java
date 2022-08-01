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
    public ListNode middleNode(ListNode head) {
        int count=0;
        ListNode tempHead = head;
        while(head!=null){
            head=head.next;
            count++;
        }
        int mid= count/2+1;
        while(mid>1){
            tempHead = tempHead.next;
            mid--;
        }
        return tempHead;
    }
}