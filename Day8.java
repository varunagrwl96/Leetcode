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
------------------------------------------------------------------------------
/*Solution by Errichto */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode pointer1=head,pointer2=head;
        while(pointer2!=null){
            pointer2=pointer2.next;
            if(pointer2==null){
             return pointer1;   
            }
            pointer2=pointer2.next;
            pointer1=pointer1.next;
        }
        return pointer1;
    }
}