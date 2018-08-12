package interview.string;

//14. Longest Common Prefix
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        Arrays.sort(strs);
        String f=strs[0],l=strs[strs.length-1];
        if(f.length()==0) return f;
        int i=0,len= Math.min(f.length(),l.length());
        StringBuilder sb= new StringBuilder();
        while(i<len&&f.charAt(i)==l.charAt(i))
        { 
            sb.append(f.charAt(i));i++;
        }
        return sb.toString();
    }
}