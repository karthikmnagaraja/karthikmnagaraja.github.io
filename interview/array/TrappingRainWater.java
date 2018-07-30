package interview.array;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.
Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
Challenge
O(n) time and O(1) memory
O(n) time and O(n) memory is also acceptable.
Tags Expand 
Two Pointers Forward-Backward Traversal Array
Related Problems Expand 
Medium Container With Most Water
LeetCode:
Tags: Array, Two Pointers
Similar Problems: (M) Container With Most Water, (M) Product of Array Except Self
*/
/*
Thoughts:
Two Pointer
The two pointer approach respects the central heightest point:
The entire structure is divided by the central highest point, where maxLeft == maxRight.
Before left and right meet on this point, keep left++, right--.
Time: O(n)
Space: O(1)
*/
public class TrappingRainWater{
	public static void main(String args[]){
         
        int[] inputArr = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater mms = new TrappingRainWater();
        int result=mms.trap(inputArr);
        
            System.out.print(result);
          
    }

    public int trap(int[] a) {
        if(a.length==0) return 0;
        int left=0,maxLeft=0,maxRight=0,right=a.length-1, res=0;
        while(left<right){
            if(a[left]<=a[right]){
                if(a[left]>maxLeft) maxLeft=a[left];
                else res+=maxLeft-a[left];
                left++;
            }else{
                if(a[right]>maxRight)maxRight=a[right];
                else res+=maxRight-a[right];
                right--;
            }
        }
        return res;
    }
}