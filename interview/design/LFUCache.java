package interview.design;
class LFUCache {
    int capacity;
    HashMap<Integer,Integer> keyValue;
    HashMap<Integer,Integer> keyCount;
    HashMap<Integer,LinkedHashSet<Integer>> frequencyMap;
    int min=-1;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        keyValue= new HashMap<Integer,Integer>();
         keyCount= new HashMap<Integer,Integer>();
         frequencyMap= new HashMap<Integer,LinkedHashSet<Integer>>();
        frequencyMap.put(1,new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        if(!keyValue.containsKey(key)) 
            return -1;
        

        int count=keyCount.get(key);

        keyCount.put(key,count+1);
        frequencyMap.get(count).remove(key);
        if(count==min && frequencyMap.get(count).size()==0)   min++;
        if(!frequencyMap.containsKey(count+1))frequencyMap.put(count+1,new LinkedHashSet<>());
        frequencyMap.get(count+1).add(key);
        return keyValue.get(key);
        
    }
    
    public void put(int key, int value) {
        if(capacity<=0) return;
        if(keyValue.containsKey(key)){
            keyValue.put(key,value);
            get(key);
            return;
        }else{
            if(keyValue.size()>=capacity){
                int lkey=frequencyMap.get(min).iterator().next();
                keyValue.remove(lkey);
                keyCount.remove(lkey);
                System.out.println(frequencyMap.get(min).toString()+" key"+lkey);
                frequencyMap.get(min).remove(lkey);
            }
            keyValue.put(key,value);
            keyCount.put(key,1);
            frequencyMap.get(1).add(key);
            min=1;
        }
    }
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */