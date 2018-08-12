package interview.math;

//50. Pow(x, n)
public class Pow(x,n) {
    public double myPow(double x, int n) {
        if(n==0) return 1;
         if(n==Integer.MIN_VALUE) return myPow(x,n+1)/x;
        if(n<0){
            
        
            x=1/x;
           
                n=-n;
            
        }
        double half=myPow(x,n/2);
        if(n%2==0) return half*half;
        else return half*half*x;
    }
}