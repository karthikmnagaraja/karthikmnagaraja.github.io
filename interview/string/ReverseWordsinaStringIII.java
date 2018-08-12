package interview.string;
//557. ReverseWordsinaStringIII
class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        if(s.length()==0) return s;
        int start=0;
        s=s.trim();
        char[] ch=s.toCharArray(); 
        for(int i=0;i<ch.length;i++){
            if(ch[i]==' '){
                reverseString(ch,start,i-1);
                start=i+1;
            }
        }
        reverseString(ch,start,ch.length-1);
        return String.valueOf(ch);
    }
     public void reverseString(char[] ch, int l, int r) {
        
        while(l<r){
            char c=ch[l];
            ch[l]=ch[r];
            ch[r]=c;
            l++;
            r--;
        }
        
        
    }
}