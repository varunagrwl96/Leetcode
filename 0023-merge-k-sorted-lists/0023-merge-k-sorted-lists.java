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
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)->a.val-b.val);
        ListNode ans = new ListNode();
        ListNode anshead = ans;
        for(ListNode node : lists){
            if(node!=null){
              pq.add(node);  
            }
        }
        while(!pq.isEmpty()){
            ListNode popped = pq.poll();
            ans.next = new ListNode(popped.val);
            ans=ans.next;
            if(popped.next!=null){
                pq.add(popped.next);
            }
        }
        return anshead.next;
    }
}
//Time O(nlogk)
//Space O(n)