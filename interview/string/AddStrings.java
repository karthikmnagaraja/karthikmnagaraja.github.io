package interview.string;
//415. Add Strings
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb= new StringBuilder();
        if(num1.length()==0&&num2.length()==0) return sb.toString();
        
        int l=num1.length()-1,r=num2.length()-1;
        int result=0;
        while(l>=0||r>=0){
            result+=(l>=0)?num1.charAt(l)-'0':0;
            result+=(r>=0)?num2.charAt(r)-'0':0;
            sb.append(result%10);
            result/=10;
            l--;r--;
        }
        if(result!=0) sb.append(result);
        return sb.reverse().toString();
    }
}