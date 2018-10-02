

package interview.greedy;
public class CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] result= new Integer[nums.length];
        List<Integer> sorted= new ArrayList<Integer>();
        for(int i=nums.length-1;i>=0;i--){
            int idx= findIndex(sorted,nums[i]);
            result[i]=idx;
            sorted.add(idx,nums[i]);
        }
        return Arrays.asList(result);
    }
    public int findIndex(List<Integer> s, int key){
        if(s.size()==0) return 0;
        int start=0,end=s.size()-1;
        if(s.get(end)<key) return end+1;
        if(s.get(start)>=key) return start;
        while(start<end){
            int mid=(start+end)/2;
           
            if(s.get(mid)<key) 
                start=mid+1;
            else end=mid;
        }
        return s.get(start)>key?start:end;
    }
}