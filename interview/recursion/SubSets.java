package interview.recursion;

import java.util.*;

public class SubSets{

	public static void main(String[] args) {
		SubSets s= new SubSets();
		int[] num= {1,2,3};
		List<List<Integer>> result=s.subsets(num);
		for(List<Integer> i:result)
		{
			System.out.println(i.toString());
		}
		System.out.println("Total SubSets/Combinations: " +result.size());
	}

	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> result= new ArrayList<List<Integer>>();
		helper(nums,0,new ArrayList<Integer>(),result);
		return result;
	}

	public void helper(int[]nums,int index,List<Integer> temp, List<List<Integer>> result){
		result.add(new ArrayList<Integer>(temp));
		for(int i=index;i<nums.length;i++){
			temp.add(nums[i]);
			helper(nums,i+1,temp,result);
			temp.remove(temp.size()-1);
		}
	}

}