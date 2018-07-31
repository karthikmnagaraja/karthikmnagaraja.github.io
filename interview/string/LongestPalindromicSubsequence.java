package interview.string;

//516. Longest Palindromic Subsequence
/**
Order of character matters since its a subsequence
Standard Dynammic programming
Base Case
Considers have 2 pointers start and end string
1. s[start]==s[end] 2+helper(start+1,end-1,s);
2. s[start]!=s[end] Math.max(helper(start+1,end,s),helper(start,end-1,s))
3. start==end  return 1
4. start>end return 0
**/
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        return helper(0,s.length()-1,s,new int[s.length()][s.length()]);
    }
    public int helper(int start,int end,String s, int[][] cache){
        if(cache[start][end]!=0) return cache[start][end];
        if(start>end) return 0;
        if(start==end) return 1;
        
        
        int result=0;
        if(s.charAt(start)==s.charAt(end))
            result=2+helper(start+1,end-1,s,cache);
        else result= Math.max(helper(start,end-1,s,cache),helper(start+1,end,s,cache));
         cache[start][end]=result;
        return result;
    }
}