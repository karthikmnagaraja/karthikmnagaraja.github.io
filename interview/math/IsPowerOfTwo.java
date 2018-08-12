
package interview.math;
//231. Power of Two
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n&n-1)==0;
    }
}