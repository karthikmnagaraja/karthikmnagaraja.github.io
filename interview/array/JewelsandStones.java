package interview.array;

public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        int[] f=new int[128];
        for(char c:J.toCharArray())
            f[c]++;
        int res=0;
        for(char c:S.toCharArray()){
            if(f[c]!=0)
            {
                res++;
            }
        }
        return res;
    }
}