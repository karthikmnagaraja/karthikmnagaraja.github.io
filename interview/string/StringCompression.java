package interview.string;

public class StringCompression {
    public int compress(char[] chars) {
        int idx=0;
        int i=0;
        while(i<chars.length){
            int count=0;char ch=chars[idx];
            while(i<chars.length&&ch==chars[i]){
                count++;
                i++;
            }
            chars[idx++]=ch;
            if(count!=1){
                for(char c:String.valueOf(count).toCharArray()){
                    chars[idx++]=c;
                }
            }
        }
        return idx;
    }
}