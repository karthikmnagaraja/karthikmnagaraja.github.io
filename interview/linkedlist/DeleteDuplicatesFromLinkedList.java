package interview.linkedlist;

/**
TimeComplexity is O(n)
*/
public class DeleteDuplicatesFromLinkedList { 
 public ListNode deleteDuplicates(ListNode head) {
        ListNode start=head;
       
        while(start!=null&&start.next!=null){
            while(start.next!=null && start.val==start.next.val)
                start.next=start.next.next;
            start=start.next;
            
        }
        return head;
    }
  }