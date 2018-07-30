package interview.dp;

/**
To get the DP solution, analyse the pattern first by generating first few solutions
1: 1
2: 2
3: 3
4: 4
5: 5
6: 5 (Ctrl c, Ctrl v,Ctrl c,Ctrl v,Ctrl v)
7: 7
8: 6
9: 6
10: 7
11: 11
12: 7
13: 13
14: 14
15: 8

If the n is prime number then it take n times to generate it.
other wise find all the smallest factors possible and add it to the result.
*/

public class 2KeysKeyboard {
    public int minSteps(int n) {
        if(n==1) return 0;
        for(int i=2;i<=n;i++){
            if(n%i==0) return i+minSteps(n/i);
        }
        return 0;
    }
}