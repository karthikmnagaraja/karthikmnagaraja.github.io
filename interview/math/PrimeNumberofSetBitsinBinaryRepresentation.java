package interview.math;

/**
2 Steps to find the prime number of set bits in a given integer
1.Count the number of 1's
2.IsPrime(count)-> note count will be below 32 since size of integer is 32bits so check all the prime number under 32 if it is then include otherwise exclude.
*/

public class PrimeNumberofSetBitsinBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
       
        int count = 0;
        for (int i = L; i <= R; i++)
            count += isPrime(Integer.bitCount(i)) ? 1 : 0;
        return count;
    }
    
    public boolean isPrime(int x) {
        return x == 2 || x == 3 || x == 5 || x== 7 || x == 11 || x == 13 || x == 17 || x== 19;
    }
}