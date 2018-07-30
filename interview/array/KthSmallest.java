package interview.array;
/**
378. Kth Smallest Element in a Sorted Matrix
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
Approach 1
Using Priority Queue
1.Build min Heap from the first row of elements aka add the first row elements to the priority queue
2.Do the following for k-1 times
Poll first to get the cur smallest element from the list (which will be first element of the matrix for the first time)
 the add the row+1,col in the matrix to the PQ
3. poll the PQ for the k-1 th time to find the kth smallest element from the matrix
SpaceComplexity O(n) worst case since there may be duplicate elements in the matrix
TimeComplexit is O(klogk)

Approach 2.
Using Binary Search over Range not index
Let's think about this problem in another way:
The key point for any binary search is to figure out the "Search Space". For me, I think there are two kind of "Search Space" -- index and range(the range from the smallest number to the biggest number). Most usually, when the array is sorted in one direction, we can use index as "search space", when the array is unsorted and we are going to find a specific number, we can use "range".

Let me give you two examples of these two "search space"

index -- A bunch of examples -- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ ( the array is sorted)
range -- https://leetcode.com/problems/find-the-duplicate-number/ (Unsorted Array)
The reason why we did not use index as "search space" for this problem is the matrix is sorted in two directions, we can not find a linear way to map the number and its index.

Repeat steps from 1 to 3
For this problem the range is lo=matrix[0][0],hi=matrix[matrix.length-1][matrix[0].length-1](hi is inclusive here)
Step 1.calculate mid=lo+(hi-lo)/2 *** dont calculate using mid=(hi+low)/2 since hi and low are not indices but values
Step 2.Count the number of values which are less than mid
Step 3. if the count is more than k then decrease the search range hi=mid-1 or if less than k lo=mid+1;

Final Step return result lo

Similar Problems
786. K-th Smallest Prime Fraction

774	Minimize Max Distance to Gas Station

719. Find K-th Smallest Pair Distance

668. Kth Smallest Number in Multiplication Table

644. Maximum Average Subarray II

378. Kth Smallest Element in a Sorted Matrix
*/
class KthSmallest {

	/**Approach 1 Using Priority Queue*/
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq= new PriorityQueue<Tuple>((a,b)->a.val-b.val);
        int n=matrix.length;
        for(int j=0;j<n;j++) pq.offer(new Tuple(0,j,matrix[0][j]));
        for(int i=0;i<k-1;i++){
            Tuple t=pq.poll();
            if(t.x<n-1) pq.offer(new Tuple(t.x+1,t.y,matrix[t.x+1][t.y]));
        }
        return pq.isEmpty()?-1:pq.poll().val;
    }
    
    class Tuple{
        int x,y,val;
        public Tuple(int x, int y, int val){
            this.x=x;this.y=y;this.val=val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
    	int lo=matrix[0][0],hi=matrix[matrix.length-1][matrix[0].length-1];
    	while(lo<=hi){
    		int mid=lo+(hi-lo)/2;
    		int count=countSmallers(matrix,mid);
    		if(count>k)hi=mid-1;
    		else lo=mid+1;
    	}
    	return lo;
    }
    private int countSmallers(int[][]matrix,int mid){
    	int i=0,j=matrix[0].length-1,count=0;
    	while(i<matrix.length&&j>=0){
    		if(matrix[i][j]>mid){
    			j--;
    		}else{
    			i++;
    			count+=(j+1);
    		}
    	}
    	return count;
    }


}