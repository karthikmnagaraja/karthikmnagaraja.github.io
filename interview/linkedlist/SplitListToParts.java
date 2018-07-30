package interview.linkedlist;

/**
TimeComplexity is O(n)
*/
public class SplitListToParts {


public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] a=new ListNode[k];
        int len=0;
        for(ListNode node=root;node!=null;node=node.next) len++;
        
        int w=len/k,r=len%k;
        ListNode node=root;
         
        for(int i=0;i<k;i++,r--){
           ListNode pre=null;
            a[i]=node;
            for(int j=0;j<w+(r>0?1:0);j++){
                pre=node;
                node=node.next;
            }
            if(pre!=null)pre.next=null;
        }
        return a;
    }



 }