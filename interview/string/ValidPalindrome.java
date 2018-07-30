package interview.string;
/*
125. Valid Palindrome
DescriptionHintsSubmissionsDiscussSolution
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/
/**
Thoughts:
1.Input string might consists of characters otherthan alpha numeric so ignore other characters
2.Start from left and right both sides if its not alphanumerica the increment for left or decrement for right.
3. Convert both character to lower case and Compare if they are not equal return true.
4. If you reach the end of the string then didnt find any mismatch of characters so return true.
Space:O(1)
Time Complexity:O(n) where n is the length of the input string.
*/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l<=r){
            char a=s.charAt(l);
            char b=s.charAt(r);
            if(!isValid(a)){
                l++;
                continue;
            }
            if(!isValid(b)){
                r--;
                continue;
            }
            if(Character.toLowerCase(a)!=Character.toLowerCase(b)){
                
                return false;
            } 
            r--;
            l++;
        }
        return true;
    }
    public boolean isValid(char ch){
        if(ch>='a'&&ch<='z') return true;
        if(ch>='A'&&ch<='Z') return true;
        if(ch>='0'&&ch<='9') return true;
        return false;
    }
}