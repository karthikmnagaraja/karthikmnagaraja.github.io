package interview.linkedlist;

public class MergeKLists {

public ListNode mergeKLists(ListNode[] lists) {
       return sort(lists,0,lists.length-1);
    }
    
   public ListNode sort(ListNode[] lists,int start,int end){
        if(start==end) return lists[start];
        else if (start<end){
            int mid=(start+end)/2;
            ListNode a=sort(lists,start,mid);
            ListNode b=sort(lists,mid+1,end);
            return merge(a,b);
        }else return null;
    }
    public ListNode merge(ListNode a, ListNode b){
        ListNode node=new ListNode(-1);
        ListNode n=node;
        while(a!=null&&b!=null){
            if(a.val<=b.val){
                n.next=a;
                a=a.next;  
            }else{
                n.next=b;
                b=b.next;
            }
            n=n.next;
        }
        if(a!=null)n.next=a;
        if(b!=null)n.next=b;
        return node.next;
    }

 }