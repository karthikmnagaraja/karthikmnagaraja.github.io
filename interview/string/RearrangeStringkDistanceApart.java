package interview.string;
/**
358. Rearrange String k Distance Apart
Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:

Input: s = "aabbcc", k = 3
Output: "abcabc" 
Explanation: The same letters are at least distance 3 from each other.
Example 2:

Input: s = "aaabc", k = 3
Output: "" 
Explanation: It is not possible to rearrange the string*/
public class RearrangeStringkDistanceApart{
    public String rearrangeString(String s, int k) {
        if(k==0||s.length()==0) return s;
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Queue<Map.Entry<Character,Integer>> q= new PriorityQueue<Map.Entry<Character,Integer>>((a,b)->b.getValue()-a.getValue());
        q.addAll(map.entrySet());
        List<Map.Entry<Character,Integer>> list= new LinkedList<Map.Entry<Character,Integer>>();
        StringBuilder sb= new StringBuilder();
        while(!q.isEmpty()){
            Map.Entry<Character,Integer> e= q.poll();
            sb.append(e.getKey());
            e.setValue(e.getValue()-1);
           list.add(e);
            if(sb.length()>=k){
                 Map.Entry<Character, Integer> front = list.remove(0); // release 1st (char, freq) from waitlist and add back to pq if freq still > 0
                if (front.getValue() > 0) q.offer(front); 
            }
        }
        return (sb.length()==s.length())?sb.toString():"";
    }
}