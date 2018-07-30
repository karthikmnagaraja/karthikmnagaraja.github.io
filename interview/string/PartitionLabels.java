package interview.string;
/**
Thoughts to be written its still unclear.
*/
class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        if(S.length()==0) new ArrayList<Integer>();
        int[] f=new int[26];
        for(int i=0;i<S.length();i++)f[S.charAt(i)-'a']=i;
        List<Integer> list=new ArrayList<Integer>();
        int start=0,last=0;
        for(int i=0;i<S.length();i++){
            last=Math.max(last,f[S.charAt(i)-'a']);
            if(last==i){
                list.add(last-start+1);
                start=last+1;
            }
        }
        return list;
        
    }
}

