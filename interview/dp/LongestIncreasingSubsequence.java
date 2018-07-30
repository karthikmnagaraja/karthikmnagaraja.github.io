package interview.dp;

/**
Thoughts:
1.Declare a result array with n+1 elements since there might be ducplicates too.
2.There are 3 cases involved in this soluction
case 1; a[i] might be smallest so far set as the first element of the result array.
case 2: a[i] might be largest so far set as the length of the longest sub sequence in the result array. append at the end of the result array and increase the length .
case 3: a[i] is an intermediate element a[0]<a[i]<a[len-1] where len of lis. do a binary search over index to find the closest smaller element to value of a[i].
*/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] A) {
        
        
        int size=A.length;
        if(size==0) return 0;
        int[] lis= new int[A.length+1];
        int len=1;
        lis[0]=A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]<lis[0]) lis[0]=A[i];
            else if(A[i]>lis[len-1]) lis[len++]=A[i];
            else{
                int idx=findIndex(A,len-1,A[i]);
                lis[idx]=A[i];
            }
            
        }
        System.out.println(Arrays.toString(lis));
        return len;
        
    }
    public int findIndex(int[] nums,int hi,int key){
        
        while(hi>lo){
            int mid=(lo+hi)/2;
            if(nums[mid]>key){
                hi=mid;
            }else lo=mid+1;
        }
        return lo;
    }
}