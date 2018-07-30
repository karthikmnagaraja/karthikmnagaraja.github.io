package interview.sorting;

public class MergeKSortedArrays{
//Sort all characters in a string
	public static void main(String args[]){
         
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        MergeSort mms = new MergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public class Node{
    	int[] arr;
    	int index;
    	public Node(int[] arr,int index){
    		this.arr=arr;
    		this.index=index;
    	}
    	
    }
    public List<Integer> mergeKSortedArrays(int[][] a){

    	PriorityQueue<Node> pq= new PriorityQueue((a,b)->a.arr[index]-b.arr[index]);
    	for(int i=0;i<a.length;i++){
    			pq.add(new Node(a[i],0));
    	}
    	List<Integer> result= new ArrayList<Integer>();
    	while(!pq.isEmpty()){
    		Node n=pq.remove();
    		result.add(node.arr[node.index]);
    		if(node.arr.length>node.index){
    			node.index++;
    			pq.add(node);
    		}

    	}
    	return result;
    }
}