package interview.design;

/**

*/
public class InsertDeleteGetRandom {
    Map<Integer,Integer> map= new HashMap<Integer,Integer>();
    List<Integer> list= new ArrayList<Integer>();
    java.util.Random random= new java.util.Random();
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        
    }
    

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
   
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int loc=map.get(val);
        if(list.size()-1>loc){
            int last=list.get(list.size()-1);
            list.set(loc,last);  
             map.put(last,loc);
        }
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}