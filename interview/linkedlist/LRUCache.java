package interview.linkedlist;


public class LRUCache 
{
    int size;
    Node head,tail;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        size=capacity;
        map= new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node= map.get(key);
            node.value=value;
            remove(node);
            setHead(node);
        }else{
            if(map.size()>=size){
                Node tail=this.tail;
                map.remove(tail.key);
                remove(tail);
            }
            Node node= new Node(key,value);
            map.put(key,node);
            setHead(node);
        }
    }
    
    public void remove(Node node){
        if(node.prev!=null)
            node.prev.next=node.next;
        else head= node.next;
        if(node.next!=null)
            node.next.prev=node.prev;
        else tail=node.prev;
    } 
    public void setHead(Node n){
        n.next=head;
        n.prev=null;
        if(head!=null) head.prev=n;
        head=n;
        if(tail==null) tail=n;
    }
    public static class Node{
        int key,value;
        Node next,prev;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
        
    }
}