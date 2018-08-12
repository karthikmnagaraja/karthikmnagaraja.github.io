package interview.string;
//344. ReverseString
class ReverseString {
    public String reverseString(String s) {
        if(s.length()<2) return s;
        char[] ch=s.toCharArray();
       int l=0,r=ch.length-1;
        while(l<r){
            char c=ch[l];
            ch[l]=ch[r];
            ch[r]=c;
            l++;
            r--;
        }
        
        return new String(ch);
    }
    
}