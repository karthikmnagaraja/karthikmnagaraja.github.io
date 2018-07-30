package interview.math;


public class WaterandJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z) return false;
        if(x==z||y==z||x+y==z)  return true;
        
        return z%gcd(x,y)==0;
    }
    
    public int gcd(int x,int y){
        while(y!=0){
            int t=y;
            y=x%y;
            x=t;
        }
        return x;
    }
    
   
}