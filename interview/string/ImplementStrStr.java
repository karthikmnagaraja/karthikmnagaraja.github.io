package interview.string;
/*
28. Implement strStr()
DescriptionHintsSubmissionsDiscussSolution
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/
/**
Thoughts:
1.needle length==0 then return 0;
2. if needle length>haystack.length return -1 since we cannot find longer string in smaller string
3. if needle is same as haystack then 0;
4. 
Time:O(n);
Space:O(1);
*/

class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if(needle.length()>haystack.length()) return -1;
        if(haystack.equals(needle)) return 0;
        int len=haystack.length()-needle.length()+1;
        for(int i=0;i<len;i++){
            int j=i,k=0;
            while(j<haystack.length()&&k<needle.length()&&haystack.charAt(j)==needle.charAt(k)){
                j++;
                k++;
            }
            if(k==needle.length()){
                return i;
            }
        }
        return -1;
    }
}