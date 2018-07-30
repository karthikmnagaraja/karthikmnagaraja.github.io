package interview.recursion;

import java.util.*;
/**
https://leetcode.com/problems/subsets-ii/description/
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/
/**
Thoughts:
1.F
*/
public class SubSets2{

	public static void main(String[] args) {
		SubSets2 s= new SubSets2();
		int[] num= {1,2,3};
		List<List<Integer>> result=s.subsets(num);
		for(List<Integer> i:result)
		{
			System.out.println(i.toString());
		}
		System.out.println("Total SubSets/Combinations: " +result.size());
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> result= new ArrayList<List<Integer>>();
        Arrays.sort(nums);
		helper(nums,0,new ArrayList<Integer>(),result);
		return result;
	}

	public void helper(int[]nums,int index,List<Integer> temp, List<List<Integer>> result){
		
        result.add(new ArrayList<Integer>(temp));
		for(int i=index;i<nums.length;i++){
            if(i==index||nums[i]!=nums[i-1]){
			temp.add(nums[i]);
			helper(nums,i+1,temp,result);
			temp.remove(temp.size()-1);
            }
            
		}
	}

}