package interview.sorting;
/*
FindKthLargest
Parttion the array 0-k k+1->end in descending order
return k-1 the element since array index start from 0;

QUick Slect algorithm
1.Partition the array with last element as pivot (sort the elements in descending order)
2. If partition index is greater than kth element then end=p-1 else start=p+1;

*/
class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {

        return sort(nums,0,nums.length-1,k-1);
    }
    
    public int sort(int[]nums,int start,int end,int k){
       
        
            int p=partition(nums,start,end);
            if(k==p)return nums[p];
            else if(k<p)return sort(nums,start,p-1,k);
            else return sort(nums,p+1,end,k);
        
    }
    public int partition(int[] nums, int start, int end){
        
         int pivot=nums[end];
        int s=start-1;
        for(int i=start;i<end;i++){
        //catch is here swap the element if its greater than pivot element so the array will be sorted in descending order
            if(nums[i]>=pivot){
                s++;
                swap(nums,s,i);
            }
        }
        swap(nums,s+1,end);
        return s+1;
    }
    
    public void swap(int[] nums,int i,int j){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }
    
}