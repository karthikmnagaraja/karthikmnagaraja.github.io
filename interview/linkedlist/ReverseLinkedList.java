package interview.linkedlist;
/*
206. Reverse Linked List
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
*/
/**	
TimeComplexity is O(n)
*/
public class ReverseLinkedList{

public ListNode reverseListItr(ListNode head) {
        ListNode cur=head,prev=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    
    public ListNode reverseList(ListNode head){
        return reverse(head,null);
        
    }
    public ListNode reverse(ListNode cur,ListNode prev){
        if(cur==null) return prev;
        ListNode next=cur.next;
        cur.next=prev;
        return reverse(next,cur);
        
    }

 }