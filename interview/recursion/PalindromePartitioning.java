package interview.recursion;

//131. Palindrome Partitioning

public class PalindromePartitioning{

public List<List<String>> partition(String s) {
		ArrayList<List<String>> result= new ArrayList<List<String>>();
        partition(s, new ArrayList<>(),result);
		return result;
    }
	
	public void partition(String s,List<String> list,List<List<String>> result){
		if(s.length()==0) result.add(new ArrayList<String>(list));
		
		for(int i=0;i<s.length();i++){
			if(isPal(s,0,i)){
				list.add(s.substring(0,i+1));
				partition(s.substring(i),list,result);
				list.remove(list.size()-1);
			}
		}
	}
	public boolean isPal(String s,int left,int right){
		while(left<right){
			if(s.charAt(left++)!=s.charAt(right--)){
				return false;
			}
		}
		return true;
	}
  
 }
