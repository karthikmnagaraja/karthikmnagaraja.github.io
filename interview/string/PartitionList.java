//86. Partition List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode slow=new ListNode(-1);
        ListNode fast=new ListNode(-1);
        ListNode ds=slow,df=fast;
        while(head!=null){
            if(head.val<x){
                slow.next=head;
                slow=slow.next;
               
            }else{
                fast.next=head;
                fast=fast.next;
               
            }
            head=head.next;
        }
        fast.next=null;
        slow.next=df.next;
        
        return ds.next;
    }
}