package interview.string;


//647. Palindromic Substrings
public class PalindromicSubstrings {
    int count=0;
    public int countSubstrings(String s) {
        if(s.length()==0) return 0;
        
        for(int i=0;i<s.length();i++){
            isPalindrome(i,i,s);
            isPalindrome(i,i+1,s);
        }
        return count;
    }
    void isPalindrome(int s,int e,String str)
    {
        while(e<str.length()&&s>=0&&str.charAt(s)==str.charAt(e)){
            s--;
            e++;
            count++;
        }
       
    }
}