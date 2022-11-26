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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;
        int carry=0;
        ListNode ans = new ListNode();
        ListNode anshead = ans;
        while(l1!=null || l2!=null){
            int v1 = l1==null?0:l1.val;
            int v2 = l2==null?0:l2.val;
            sum=v1+v2+carry;
            carry=0;
            if(sum<9){
                ans.next = new ListNode(sum);
                ans=ans.next;
            }else{
                carry = sum/10;
                sum=sum%10;
                ans.next = new ListNode(sum);
                ans=ans.next;
            }
            l1=l1==null?l1:l1.next;
            l2=l2==null?l2:l2.next;
        }
        if(carry!=0){
            ans.next=new ListNode(carry);
        }
        return anshead.next;
    }
}