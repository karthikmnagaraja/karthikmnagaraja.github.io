package interview.sorting;



public class LinkedListSort{
ListNode sort(ListNode list){
	if(list==null|| list.next==null) return list;
	ListNode mid=midLL(list);
	List rightStart=mid.next;
	mid.next=null;
	ListNode left=sort(list);
	ListNode right=sort(rightStart);
	return merge(left,right);
}

private static ListNode midLL(ListNode ll){
	ListNode s=ll;
	ListNode f=ll;
	while(f!=null&f.next!=null){
		f=f.next.next;
		s=s.next;
	}
	return s;
}

private static ListNode merge(ListNode a,ListNode b){
	if(a==null) return b;
	if(b==null) return a;
	ListNode head= new ListNode(0);
	ListNode result=head;
	while(a!==null &&b!=null){
		if(a.val<=b.val){
			head.next=a;
			a=a.next;
		}else{
			head.next=b;
			b=b.next;
		}
		head=head.next;
	}
	if(a!=null) head.next=a;
	if(b!=null) head.next=b;
	 return result.next;
}
}