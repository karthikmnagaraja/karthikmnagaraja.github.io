package interview.math;

/**
Thoughts: 
X/Y=Z for Z to be greater then y should be smaller.
Main Base case so group all the elements from 1 to length in string format (n1/n2/n3...n)
then n0/(n1/n2/n3...n)

base case 
1.if there are no elements then empty string.
2. 1 element return that element in string format.
3. 2 element return num1/num2 in string.
4. so group all the elements from 1 to length in string format (n1/n2/n3...n)
then n0/(n1/n2/n3...n)
*/

public class OptimalDivision {
    public String optimalDivision(int[] nums) {
        if(nums.length==0) return "";
        if(nums.length==1) return nums[0]+"";
        if(nums.length==2) return nums[0]+"/"+nums[1];
        StringBuilder sb= new StringBuilder();
        sb.append(nums[0]).append("/(").append(nums[1]);
        for(int i=2;i<nums.length;i++){
            sb.append("/").append(nums[i]);
        }
        sb.append(")");
        return sb.toString();
        
    }
}