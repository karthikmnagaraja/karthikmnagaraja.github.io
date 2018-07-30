package interview.sorting;

public class QuickSort{
	
	 public static void main(String args[]){
         
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        QuickSort mms = new QuickSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public void sort(int[] nums){
		quickSort(nums,0,nums.length-1);
    }
    public void quickSort(int[] nums,int start, int end){
    	if(start<end){
    		int key=partition(nums,start,end);
    		quickSort(nums,start,key-1);
    		quickSort(nums,key+1,end);
    	}

    }
    public void swap(int[] nums, int i,int j){
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }

    public int partition(int[] nums, int start, int end){
    	int pivot=nums[end];
    	int i=start-1;
    	for(int j=0;j<end;j++){
    		if(a[j]<=pivot){
    			i++;
    			swap(nums,i,j);
    			
    		}
    	}
    	swap(nums,i+1,end);
    	return i+1;
    }