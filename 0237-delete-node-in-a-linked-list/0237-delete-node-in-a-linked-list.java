/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node==null) return;
        ListNode nextNode = node.next;
        if(nextNode!=null){
            node.val=nextNode.val;
            node.next = nextNode.next;
        }
    }
}