package interview.linkedlist;
/*
141. Linked List Cycle
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/
/**
TimeComplexity is O(n)
*/
public class HasCycle{

public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) return true;
        }
        return false;
    }

}