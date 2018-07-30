package interview.array;
/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.
*/
/*
Thoughts:
Bottom Up Approach
compute the string from 1-n for each iteration input of nth iteration is n-1 output value 
i.e based on previous result compute the next value.

Space Complexity is : O(n)
*/
public class CountAndSay{
	

	public String countAndSay(int n) {
       if(n<=0) return "";
        String str="1";
        for(int i=1;i<n;i++)
            str=count(str);
        return str;
    }
    
    public String count(String str){
        StringBuilder sb= new StringBuilder();
        int count=1;
        char c=str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==c) count++;
            else{
                sb.append(count).append(c);
                c=str.charAt(i);
                count=1;
            }
            
        }
        sb.append(count).append(c);
               return sb.toString();
    } 

    public static void main(String[] args) {
    	
    }
}