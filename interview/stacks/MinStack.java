package interview.stack;


//155	Min Stack
public class MinStack {
    Node top=null;
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(top==null) top=new Node(x,x);
        else{
           Node node= new Node(x,Math.min(x,top.min));
            node.next=top;
            top=node;
        }
    }
    
    public void pop() {
        if(top == null)
            return;
            Node n=top.next;
            top.next=null;
            top=n;
        
    }
    
    public int top() {
        if(top==null) return -1;
        else return top.val;
        
    }
    
    public int getMin() {
         if(top==null) return -1;
         else return top.min;
        
    }
    private static class Node{
        int min,val;
        Node next;
        public Node(int v,int m){
            min=m;val=v;
        }
    }
}