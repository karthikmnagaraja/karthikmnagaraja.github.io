package interview.math;

class SumOf2Numbers {
    public int getSum(int a, int b) {
        int s=a^b;
        int c=a&b;
        if(c==0) return s;
        else return getSum(s,c<<1);
    }
}