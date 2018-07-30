package interview.sorting;
//Sort all characters in a string
public class SortString{

	public static void main(String args[]){
         
       
        SortString mms = new SortString();
        System.out.print(mms.sort("yaxabefghuyjbcczzzz"));
        
    }

   public String sort(String str){
    	int[] f= new int[26];

    	for(char c:str.toCharArray()){
    		f[c-'a']++;
    	}
    	StringBuilder sb= new StringBuilder();

    	for(int i=0;i<26;i++)
    		while(f[i]>0){
    			sb.append((char)('a'+i)); f[i]--;
    		}
    	return sb.toString();
    }


}