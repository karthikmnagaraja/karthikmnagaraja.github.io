package interview.string;

/**
LicenseKeyFormatting
1.Key is to traverse from end and ignore all the - while traversing the the string.
2.Append the - when the target or result string length is % (k+1)=k to make sure k distance.
3.Reverse the string and convert the result to uppercase.
*/
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int k) {
        StringBuilder sb= new StringBuilder();
        for(int i=S.length()-1;i>=0;i--){
           if(S.charAt(i)!='-'){
            if(sb.length()%(k+1)==k)sb.append('-');
               //sb.length() % (k + 1) == k 
            sb.append(S.charAt(i));
           }
            
        }
        return sb.reverse().toString().toUpperCase();
    }
}