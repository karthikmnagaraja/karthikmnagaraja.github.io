package interview.string;
/**
692. Top K Frequent Words
DescriptionHintsSubmissionsDiscussSolution
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
*/
/**
1.Step compute frequency map using list of input words and number of times it appears.
2.Store only top k frequents in the prority queue using a comparator of all the words entries sort by frquency and if frequencies are same then sort lexographically.
3. Add the top k elements to the result list.
*/

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map= new HashMap<String,Integer>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq= new PriorityQueue<Map.Entry<String,Integer>>((a,b)->(a.getValue()==b.getValue()?a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue()));
        
        for(Map.Entry<String,Integer> e:map.entrySet()) pq.add(e);
        
        List<String> result= new ArrayList<String>();
        while(k>0){
            result.add(pq.poll().getKey());
            k--;
        }
        return result;
    }
    /** Approach 2 store only k elements in the priroty queue*/
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map= new HashMap<String,Integer>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq= new PriorityQueue<Map.Entry<String,Integer>>((a,b)->(a.getValue()==b.getValue()?b.getKey().compareTo(a.getKey()):a.getValue()-b.getValue()));
        
        for(Map.Entry<String,Integer> e:map.entrySet()){
        	pq.add(e);
        	if(pq.size()>k) pq.poll();
        } 
        
        List<String> result= new ArrayList<String>();
        while(!pq.isEmpty()){
            result.add(0,pq.poll().getKey());
           
        }
        return result;
    }
}