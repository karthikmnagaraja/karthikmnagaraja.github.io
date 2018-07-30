package interview.array;


/**
167. Two Sum II - Input array is sorted
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*/
/**
Thoughts:
Two Pointer Approach:
left=0 and right=a.length-1
if the sum of values of left and right indicies are equal to value then return indices
if its less than the value then increment left
else increase right
Space: O(1);
Time: O(log(n))
*/


public class TwoSum2 {
public int[] twoSum(int[] nums, int target) {
        int[] res= new int[2];
        if(nums.length<1) return  res;
        int left=0,right=nums.length-1;
        while(left<right){
            int v=nums[left]+nums[right];
            if(v==target){
                res[0]=left+1;
                res[1]=right+1;
                return res;
            }else if(v<target) left++;
            else right--;
        }
        return res;
    }
}