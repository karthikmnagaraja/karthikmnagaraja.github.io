package interview.math;
/**
a+bi)(c+di)=ac+adi+bci+bdi^2;
=ac+(ad+bc)i-bd
=(ac-bd)+(ad+bc)i

First split the array to find the coeffients of i and constants seperately and then  use the above formula to represent the result in string format
*/
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        int[] left=Stream.of(a.split("\\+|i")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int[] right=Stream.of(b.split("\\+|i")).mapToInt(num -> Integer.parseInt(num)).toArray();
        return (left[0]*right[0]-left[1]*right[1])+"+"+(left[0]*right[1]+left[1]*right[0])+"i";
    }
}