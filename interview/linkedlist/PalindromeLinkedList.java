package interview.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        
        ListNode slow=head,fast=head;
        while(fast!=null&& fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        slow=reverse(slow);
        fast=head;
        
        while(slow!=null){
            if(slow.val!=fast.val)return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
        
    }
    public ListNode reverse(ListNode node){
        ListNode cur=node,pre=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}