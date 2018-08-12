package interview.array;
//228. Summary Ranges
class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list= new ArrayList<String>();
       
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            while(i+1<nums.length&&nums[i+1]-nums[i]==1) {i++;}
            if(nums[i]==n){
                list.add(n+"");
            }else{
                list.add(n+"->"+nums[i]);
            }
        }
        return list;
    }
}