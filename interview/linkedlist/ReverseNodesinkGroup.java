package interview.linkedlist;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode node=head;
        while(count<k){
            if(node==null) return head;
            node=node.next;
            count++;
        }
        ListNode pre= reverseKGroup(node,k);
        while(count>0){
            ListNode next=head.next;
            head.next=pre;
            pre=head;
            head=next;
            count--;
        }
        return pre;
    }
}