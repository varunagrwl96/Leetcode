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
    public int getDecimalValue(ListNode head) {
        String number = "";
        while(head!=null){
            number+=String.valueOf(head.val);
            head=head.next;
        }
        // int binary = Integer.parseInt(number);
        System.out.println(number);
        int ans=0;
        int power=0;
        int i=number.length()-1;
        while(i>=0){
            int digit=Integer.parseInt(String.valueOf(number.charAt(i)));
            ans=ans + (int)(Math.pow(2,power)*digit);
            // binary=binary/10;
            power++;
            i--;
        }
        return ans;
    }
}