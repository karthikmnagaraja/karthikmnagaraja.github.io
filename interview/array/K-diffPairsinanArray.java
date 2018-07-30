package interview.array;
/**
1. we have to check in the array if any pair exist a[i]-k or a[i]+k
2. Corner case is k==0 check if there are any duplicates.
3. k(difference should be absolute difference as per the problem) so it is always positive.
*/

public class K-diffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        if(k<0) return 0;
        Map<Integer,Integer> map= new HashMap<Integer,Integer>();
        
        int count=0;
        for(int i:nums){
            if(map.containsKey(i)) {
                if(k==0&map.get(i)==1) count++;
                map.put(i,map.get(i)+1);
            }else{
                if(map.containsKey(i-k)) count++;
                if(map.containsKey(i+k)) count++;
                map.put(i,1);
            }
        }
        return count;
    }
}