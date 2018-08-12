package interview.array;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int start=0;
        for(int i:nums)if(i!=0)nums[start++]=i;
        for(int i=start;i<nums.length;i++)nums[i]=0;
        
    }
}