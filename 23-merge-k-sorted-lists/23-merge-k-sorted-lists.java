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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1,o2)->o1.val-o2.val);
        ListNode dummy = new ListNode(-1);
        ListNode head=dummy;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
                lists[i]=lists[i].next;
            }
        }
        while(pq.size()>0){
            ListNode curr = pq.poll();
            dummy.next=curr;
            dummy=dummy.next;
            if(curr.next!=null){
                pq.add(curr.next);
            }
        }
        return head.next;
    }
}