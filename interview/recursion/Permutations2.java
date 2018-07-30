package interview.recursion;

import java.util.*;

public class Permutations2{

	public static void main(String[] args) {
		Permutations2 p= new Permutations2();
		int[] num= {1,2,1};
		List<List<Integer>> result=p.permute(num);
		for(List<Integer> i:result)
		{
			System.out.println(i.toString());
		}
		System.out.println("Total Permutations: " +result.size());

	}

	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
		helper(nums,0,result);
		return result;
    }
    
    public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> result= new ArrayList<List<Integer>>();
		helper(nums,0,result);
		return result;

	}

	public void helper(int[] nums,int index,List<List<Integer>> result){
		if(nums.length-1==index){
			List<Integer> list= new ArrayList<Integer>();
			for(int i:nums) list.add(i);
			result.add(list);
			return;
		}else{
            Set<Integer> alreadyUsed= new HashSet<Integer>();
			for(int i=index;i<nums.length;i++){
                if(alreadyUsed.add(nums[i])){
				swap(nums,i,index);
				helper(nums,index+1,result);
				swap(nums,index,i);
                }
			}
		}
	}
	public void swap(int[] a, int i, int j){
		int  temp= a[i];
		a[i]=a[j];
		a[j]=temp;
	}

}