package interview.math;

public class CountPrimes {
    public int countPrimes(int n) {
        if(n<3) return 0;
        boolean[] f= new boolean[n];
        int c=n/2;
        
        for(int i=3;i*i<n;i+=2){
            if(f[i]) continue;
            for(int j=i*i;j<n;j+=i*2){
                if(!f[j]){
                    f[j]=true;
                    c--;
                }
            }
        }
        return c;
    }
}