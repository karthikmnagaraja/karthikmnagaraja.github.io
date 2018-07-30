package interview.linkedlist;

/**
TimeComplexity is O(n)
*/
public class IntersectionOf2Lists {

public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }


 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA,b=headB;
        if(a==null||b==null) return null;
        while(a!=b){
            
            a=(a!=null)?a.next:headB;
            b=(b!=null)?b.next:headA;
        }
        return a;
    }
    
 }