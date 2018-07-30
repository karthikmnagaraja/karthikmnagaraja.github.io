package interview.array;
/**
https://leetcode.com/problems/sliding-window-maximum/description/
MaximumSliding Window
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
*/
/**
Thoughts:
1. Maintain 2 arrays, to calucate max from left side and right side.
leftArr[i]=Max(leftArr[0 to (i-1)]),nums[i]);
rightArr[i]=Max(rightArr[i+1 to nums.length-1]),nums[i]);
2. maxArray[i]=Math.max(leftArr(i+k-1),rightArr(i));

Note maxArray will be shorter than input array
if input array length=n
then result array length would be n-k+1

Space Complexity= O(n) (2 intermediate arrays + 1 result array)
Time Complexity= O(n) (1 time loop to calculate leftArr and rightArr and 1 time loop to create result array)
*/

public class MaximumSlidingWindow{

 public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0||nums.length==0) return nums;
        	int []right= new int[nums.length];
        	int []left= new int[nums.length];
        	int l=0,r=nums.length-1;
            left[l++]=nums[0];
            right[r--]=nums[nums.length-1];
        	while(l<=nums.length-1&&r>=0){
        		left[l]=(l%k==0)?nums[l]:Math.max(nums[l],left[l-1]);
        		right[r]=(r%k==0)?nums[r]:Math.max(nums[r],right[r+1]);
        		l++;
        		r--;
        	}
        	int idx=0;
        	int[] result=new int[nums.length-k+1];
        	for(int i=0;i<=nums.length-k;i++){
        		result[idx++]=Math.max(left[i+k-1],right[i]);
        	}

        	return result;
    }
    public static void main(String[] args) {
    	int[] inputArr = {1,3,-1,-3,5,3,6,7};
        MaximumSlidingWindow mms = new MaximumSlidingWindow();
        int[] result=mms.product(inputArr);
        for(int i:result){
            System.out.print(i);
            System.out.print(" ");
        }
    }
	
}