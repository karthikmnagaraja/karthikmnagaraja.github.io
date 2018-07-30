package interview.sorting;
//Sort all characters in a string
public class SortColors{
public void sortColors(int[] nums) {
        int n0=0,n2=0,n1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[n2++]=2;
                nums[n1++]=1;
                nums[n0++]=0;
                    
            }else if(nums[i]==2){
                nums[n2++]=2;
            }else{
                nums[n2++]=2;
                nums[n1++]=1;
            }
        }
        
    }
}