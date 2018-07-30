package interview.sorting;

public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        if(n<2) return;
        int median=findKthLargestElement(nums,nums.length/2);
     int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }


    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }


    public int  findKthLargestElement(int[] nums,int k)
    {
        return sort(nums,0,nums.length-1,k-1);
    }
    public int sort(int[]nums,int start,int end,int k){
         System.out.println("start:"+start+" end:"+end+" k:"+k);
        int pivot=partition(nums,start,end);
        if(pivot==k) return nums[pivot];
        else if(pivot>k) return sort(nums,start,pivot-1,k);
        else return sort(nums,pivot+1,end,k);
    }
    public int partition(int[] nums,int start, int end){
        int s=start-1;
        int pivot=nums[end];
        for(int i=start;i<end;i++){
            if(nums[i]>=pivot){
                s++;
                swap(nums,s,i);
            }
        }
        swap(nums,s+1,end);
        return s+1;
        
    }
    public void swap(int[] nums,int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}