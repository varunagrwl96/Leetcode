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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddhead=head;
        if(head==null){
            return head;
        }
        ListNode evenhead = head.next;
        while(head!=null && head.next!=null){
            ListNode even = head.next;
            head.next = head.next.next;
            if(head!=null && head.next!=null)
            head=head.next;
            even.next = head.next;
            
        }
        if(head!=null)
        head.next=evenhead;
        return oddhead;
    }
}

// 1 2 3 4 5