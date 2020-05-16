O(N) time & O(1) space complexity
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode start = head;                      //used to return start of final list
        ListNode evenstart = head.next;             //to join end of odd list with start of even list
        ListNode oddend = new ListNode();
        ListNode oddhelper = new ListNode();        //used to help in joining of odd-even lists
        while(head.next!=null){
            if(head.next.next!=null){
                oddhelper=head.next.next;                   //join odd nodes 1
                head.next.next = head.next.next.next;       //join even nodes
                head.next=oddhelper;                        //join odd nodes 2
                head=head.next;                             
                if(head.next==null){
                    oddend=head;                        
                }
            }else{
                oddend=head;
                break;
            }
        }
        oddend.next=evenstart;                          //join odd end to even start
        return start;
    }
}

-----------------------------------------------
More cleaner way to write
public class Solution {
public ListNode oddEvenList(ListNode head) {
    if (head != null) {
    
        ListNode odd = head, even = head.next, evenHead = even; 
    
        while (even != null && even.next != null) {
            odd.next = odd.next.next; 
            even.next = even.next.next; 
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead; 
    }
    return head;
}}