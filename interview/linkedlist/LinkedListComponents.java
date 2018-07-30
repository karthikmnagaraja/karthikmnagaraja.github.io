package interview.linkedlist;
/*
Logic:
cur->next
cur should be an elemnt in G but not next
*/
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
       
        Set<Integer> set= new HashSet<Integer>();
        for(int i:G) set.add(i);
        int count=0;
        
        while(head!=null){
            if(set.contains(head.val)&& (head.next==null||!set.contains(head.next.val))) count++;
               head=head.next;
        }
        return count;
    }
}