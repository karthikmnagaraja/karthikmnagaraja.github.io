package interview.math;


public class SolveEquation {
    public String solveEquation(String equation) {
        String[] str=equation.split("=");
        int[] left=simplify(str[0]);
        int[] right=simplify(str[1]);
        if(left[0]==right[0]&&left[1]==right[1])  return "Infinite solutions";
        else if(left[0]==right[0]) return "No solution";
        
        return "x="+(right[1]-left[1])/(left[0]-right[0]);
    }
    
    public int[] simplify(String string){
        String[] str=string.split("(?=[+-])");
        int[] res=new int[2];
        for(String s:str){
            if(s.equals("+x")||s.equals("x"))res[0]++;
            else if(s.equals("-x")) res[0]--;
            else if(s.contains("x")) res[0]+=Integer.parseInt(s.substring(0,s.length()-1));
            else res[1]+=Integer.parseInt(s);
        }
        return res;
    }
}