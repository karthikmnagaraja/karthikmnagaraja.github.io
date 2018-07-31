package interview.string;
//159. Longest Substring with At Most Two Distinct Characters
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start=0,end=0;
        int max=0,lo=0, count=0;
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        
        while(end<s.length()){
            char e= s.charAt(end);
            
                if(map.getOrDefault(e,0)==0){
                    count++;
                }
                map.put(e,map.getOrDefault(e,0)+1);
            
            end++;
            while(count>2){
               char ss= s.charAt(start);
                map.put(ss,map.get(ss)-1);
                if(map.get(ss)==0){
                    count--;
                }
                start++;
                //System.out.println(s.substring(lo,end));
            }
            max=Math.max(max,end-start);
         
        }
        return max;
    }
}