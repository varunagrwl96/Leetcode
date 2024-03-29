/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                //cycle found, find first node of cycle
                return findFirstNode(slow,head);
            }
        }
        return null;
    }
    
    public ListNode findFirstNode(ListNode node, ListNode head){
        // Set<ListNode> hashset = new HashSet();
        // while(!hashset.contains(node)){
        //     hashset.add(node);
        //     node=node.next;
        // }
        // while(head!=null){
        //     if(hashset.contains(head)){
        //         return head;
        //     }
        //     head=head.next;
        // }
        // return null;
        while(head!=node){
            head=head.next;
            node=node.next;
        }
        return head;
    }
}
//k -> length of cycle
//Time -> O(n+k) + O(k) + O(n) = O(n)
//Space -> O(k)