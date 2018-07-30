package interview.sorting;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if(s.length()<2) return s;
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        for(char c:s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        PriorityQueue<Map.Entry<Character,Integer>> pq= new PriorityQueue<Map.Entry<Character,Integer>>((a,b)->a.getValue()!=b.getValue()?b.getValue()-a.getValue():a.getKey()-b.getKey());
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            pq.offer(e);
        }
        StringBuilder sb= new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> item=pq.poll();
            char key=item.getKey();
            int value=item.getValue();
            for(int i=0;i<value;i++)sb.append(key);
        }
        return sb.toString();
    }
}