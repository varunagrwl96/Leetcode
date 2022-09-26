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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
    }
    
    ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode();
        ListNode dummyhead = dummy;
        while(node1!=null && node2!=null){
            if(node1.val<node2.val){
                dummy.next=node1;
                dummy=dummy.next;
                node1=node1.next;
            }else{
                dummy.next=node2;
                dummy=dummy.next;
                node2=node2.next;
            }
        }
        dummy.next = (node1!=null)? node1 : node2;
        return dummyhead.next;
    }
    
    public ListNode getMid(ListNode head){
        ListNode slow=null, fast=head;
        while(fast!=null && fast.next!=null){
            slow=(slow==null)? head : slow.next;
            fast=fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next=null;
        return mid;
    }
}