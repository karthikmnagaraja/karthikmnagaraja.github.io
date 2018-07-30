package interview.array;
/*
189. Rotate Array
DescriptionHintsSubmissionsDiscussSolution
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
*/

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums.length<2||k==0||nums.length==k) return;
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
       
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public void reverse(int[] a,int s, int e){
        while(s<e){
            int t=a[s];
            a[s]=a[e];
            a[e]=t;
            s++;e--;
                
        }
    }
}