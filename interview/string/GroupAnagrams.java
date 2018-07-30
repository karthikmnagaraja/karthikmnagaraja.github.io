package interview.string;
/**
49. Group Anagrams
DescriptionHintsSubmissionsDiscussSolution
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/
/**
Thoughts:
1. Anagram is computed with respect to the number of characters and length matches.
2. For every String sort all the character which becomes the key while storing in hash map
3. Traverse through the map's key and add the value to the result.
Space:O(n)
Time:O(n)
*/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        if(strs.length==0) return new ArrayList<List<String>>();
        
        for(String s:strs){
            char[] a=s.toCharArray();
            Arrays.sort(a);
            String key= new String(a);
            if(!map.containsKey(key)){
                List<String> list= new ArrayList<String>();
                
                map.put(key,list);
            }
            map.get(key).add(s);
        }
        
        List<List<String>> result= new ArrayList<List<String>>();
        for(String key:map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}