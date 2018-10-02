package interview.string;
public class ReorganizeString {
    
     public String reorganizeString(String s) {
        if(s.length()==0) return s;
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        for (char c: s.toCharArray()) {
            map.merge(c, 1, (x, y) -> x + y);
        }
        Queue<Map.Entry<Character,Integer>> q= new PriorityQueue<Map.Entry<Character,Integer>>((a,b)->b.getValue()-a.getValue());
        q.addAll(map.entrySet());
        Queue<Map.Entry<Character,Integer>> list= new LinkedList<Map.Entry<Character,Integer>>();
        StringBuilder sb= new StringBuilder();
        while(!q.isEmpty()){
             Map.Entry<Character, Integer> entry = q.poll();
            int counter = entry.getValue();
            if (counter == 0) {
                continue;
            }
            entry.setValue(counter - 1);
            sb.append(entry.getKey());
            list.offer(entry);
            if (list.size() > 1) {
                q.offer(list.poll());
            }
        }
        return (sb.length()==s.length())?sb.toString():"";
    }
}