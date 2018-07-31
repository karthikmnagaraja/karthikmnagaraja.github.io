package interview.string;
//3. Longest Substring Without Repeating Characters
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max=0,start=0;
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                start=Math.max(start,map.get(c)+1);
            }
            map.put(c,i);
            max=Math.max(max,i-start+1);
        }
        return max;
    }
}