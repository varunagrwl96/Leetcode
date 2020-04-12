/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int counter=1;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            counter++;
        }
        int middle = --counter/2+1;
        int counter2=1;
        while(counter2 !=middle) {
            head = head.next;
            counter2++;
        }
        return head;
    }
}