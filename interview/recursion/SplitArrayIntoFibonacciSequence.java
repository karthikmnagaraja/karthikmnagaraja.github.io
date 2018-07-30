package interview.recursion;
/**
This problem is similar to word break and permutation problem.
1.Base case make a choice
2. Add it the list and call the recursive function without that choice.
3.Remove that choice from the list.

How to make a choice?
1. it shouldnt start with 0 but should consider 0 ie 011,012 are invalid choice.
2. choice converted to long shouldnt be greater than integer max value since we have to check only for intergers
3. current choice shoould be sum of previous 2 choices or number of choice made should be less than 2.

remember that considering dfs to return boolean value will terminate unwanted recursive calls and make the program to consider only valid choices hence program becomes faster.
*/
public class SplitArrayIntoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list=new ArrayList<Integer>();
         dfs(S,list,0);
        return list;
    }
    public boolean dfs(String s,List<Integer> temp, int idx){
        
        if(s.length()<=idx){
            return temp.size()>=3;
        }
        
    for(int i=idx;i<s.length();i++){
        String sub=s.substring(idx,i+1);
        if(sub.charAt(0)=='0'&&sub.length()>1) continue;
        long num=Long.parseLong(sub);
        if(num>Integer.MAX_VALUE) return false;
        int size=temp.size();
        if(size<2 || temp.get(size-1)+temp.get(size-2)==num){
            temp.add((int)num);
            if(dfs(s,temp,i+1)) return true;
            temp.remove(temp.size()-1);
        }
    }
        return false;
    }
}