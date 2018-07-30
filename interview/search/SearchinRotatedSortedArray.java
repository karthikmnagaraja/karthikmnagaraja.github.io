package interview.search;
/**
thoughts:
Step 1: Calculate the rotation index i.e how many time it has been rotated.
Step 2. based on the range where key might belong to do the binary search
*/
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int lo=0,hi=nums.length-1;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>nums[hi])
                lo=mid+1;
            else hi=mid;
        }
        if(lo>0&&target<=nums[lo-1]&&target>=nums[0]){
            return bSearch(nums,0,lo-1,target);
        }else 
            return bSearch(nums,lo,nums.length-1,target);
    }
    public int bSearch(int[] a,int lo,int hi,int key){
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(a[mid]==key) return mid;
            else if(a[mid]>key)hi=mid-1;
            else lo=mid+1;
        }
        return -1;
    }
}