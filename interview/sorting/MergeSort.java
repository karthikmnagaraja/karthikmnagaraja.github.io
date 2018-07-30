package interview.sorting;

public class MergeSort{
	
	 public static void main(String args[]){
         
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        MergeSort mms = new MergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }
	void sort(int[] nums){
		mergesort(nums, new int[nums.length],0,nums.length-1);
	}

	void mergesort(int[] nums, int[] temp,int start,int end){
		if(start<end){
			int mid=(start+end)/2;
			mergesort(nums,temp,start,mid);
			mergesort(nums,temp,mid+1,end);
			merge(nums,temp,start,mid,end);
		}

	}

	void merge(int[] nums,int[] temp,int start,int leftEnd,int rightStart, int end){
		
		int idx=start,k=start;
		while(start<=leftEnd && rightStart<=end){
				if(nums[start]<=nums[rightStart])
					temp[idx++]=nums[start++];
				else
					temp[idx++]=nums[rightStart++];
		}
		while(start<=leftEnd) 
			temp[idx++]=nums[start++];

		while(rightStart<=end) 
			temp[idx++]=nums[rightStart++];

		for(int i=k;i<end-k;i++) nums[i]=temp[i];
	}
	
		
	

}