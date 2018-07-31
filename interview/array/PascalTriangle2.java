package interview.array;

//Pascal triangle 2
public class PascalTriangle2 {
    public List<Integer> getRow(int n) {
        List<Integer> result=new ArrayList<Integer>();
        //if(n<1) return result;
        result.add(1);
        for(int i=1;i<=n;i++){
            result.add(0,1);
            for(int j=1;j<result.size()-1;j++)
                result.set(j,result.get(j)+result.get(j+1));
        }
        return result;
    }
}