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
        List<Integer> list = new ArrayList();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        int[] input = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(input);
        ListNode prev = new ListNode(-1);
        ListNode anshead=prev;
        for(int i=0;i<input.length;i++){
            ListNode curr = new ListNode(input[i]);
            prev.next=curr;
            prev=prev.next;
        }
        return anshead.next;
    }
}