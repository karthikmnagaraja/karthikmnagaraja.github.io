package interview.math;
/**
273. Integer to English Words
DescriptionHintsSubmissionsDiscussSolution
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

*/

public class IntegertoEnglishWords {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {	
        
        return num==0?"Zero":helper(num);
    }
    public String helper(int num){
        String result="";
        if(num<20)  result= LESS_THAN_20[num%20];
        else if(num<100)  result= TENS[num/10]+" "+helper(num%10);
        else if(num<1000)  result=LESS_THAN_20[num/100]+" Hundred "+ helper(num%100);
        else if(num<1000000)  result=helper(num/1000)+" Thousand "+ helper(num%1000);
        else if(num<1000000000) result=helper(num/1000000)+" Million "+ helper(num%1000000); 
        else  result=helper(num/1000000000)+ " Billion "+ helper(num%1000000000);
        return result.trim();
    }
}