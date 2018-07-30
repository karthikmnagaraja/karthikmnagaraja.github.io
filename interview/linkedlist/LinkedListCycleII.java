package interview.linkedlist;

/**
Move the fast ptr  by 2 nodes and slow ptr by a node until they are equal
if you reach end of list before that then there no cycle return null
then
point slow to head, and move both slow and fast by a node everytime untill they meet. when fast==slow return slow;
*/

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head,slow=head;
        
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            
            if(slow==fast){
                slow=head;
               
                
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
        
    }
}