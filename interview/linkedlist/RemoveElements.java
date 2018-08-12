package interview.linkedlist;

//203. Remove Linked List Elements
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        head.next=removeElements(head.next,val);
        return head.val==val?head.next:head;
    }
}