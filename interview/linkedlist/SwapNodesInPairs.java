pacakge interview.linkedlist;
/**
Thoughts:
Base Case:
1. node is null return node
2. node.next is null return node since there is only one node
3.  swap first node with second node
4. point the first node next to swap of remaining node recusively
5. 
*/

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode remaining=head.next.next;
        ListNode newHead=head.next;
        head.next.next=head;
        head.next=swapPairs(remaining);
        return newHead;
    }
}