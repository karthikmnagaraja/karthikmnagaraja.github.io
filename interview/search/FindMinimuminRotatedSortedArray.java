package interview.search;
/**
Thoughts:
[4,5,6,7,0,1,2] 
[6,7,0,1,2,4,5]
search the 

*/
class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int lo=0,hi=nums.length-1;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>nums[hi]) lo=mid+1;
            else hi=mid;
        }
        return nums[lo];
    }
}