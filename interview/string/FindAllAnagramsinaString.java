package interview.string;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result= new ArrayList<Integer>();
        if(p.length()==0) return result;
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        for(char a:p.toCharArray())map.put(a,map.getOrDefault(a,0)+1);
        int size=map.size();
        int start=0,end=0;
        while(end<s.length()){
            char e=s.charAt(end);
            if(map.containsKey(e)){
                map.put(e,map.get(e)-1);
                if(map.get(e)==0)size--;
            }
            end++;
            while(size==0){
                char st=s.charAt(start);
               
                if(end-start==p.length()) result.add(start);
            if(map.containsKey(st)){
                map.put(st,map.get(st)+1);
                if(map.get(st)>0)size++;
            }
                start++;
            }
        }
        return result;
    }
}