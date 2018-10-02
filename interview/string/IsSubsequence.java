package interview.string;
/**

*/
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int index=-1;
        for(char c:s.toCharArray()){
            index=t.indexOf(c,index+1);
            if(index==-1) return false;
                
        }
        return true;
    }
}