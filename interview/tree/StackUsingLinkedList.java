package interview.stacks;
public class StackUsingLinkedList{
	int size=0;
	Node head=null;
	public void push(int data){
		Node newNode= new Node(data);
		size++;
		if(head==null){
			head=newNode;
		}else{
			
			newNode.next=head;
			head=newNode;
		}
	}

	public int peek(){
		return size==0?-1:head.getData();
	}

	public int pop(){
		if(size==0){
			return -1;
		}else{
			Node node=head;

			head=head.next;
			node.next=null;
			size--;
			return node.getData();
		}
	}
	public int getSize(){
		return this.size;
	}

	public void printStack(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList stck = new StackUsingLinkedList();
        stck.push(1);
        stck.push(2);
        stck.push(4);
        stck.printStack();
        System.out.println("Size" + stck.getSize());
        System.out.println("Pop out element " + stck.pop());
         System.out.println("Size" + stck.getSize());
        stck.printStack();
    }
}