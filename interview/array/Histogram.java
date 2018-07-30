package interview.array;
/**
https://leetcode.com/problems/largest-rectangle-in-histogram/description/
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10

Two key points that I found helpful while understanding the solution:

1.Do push all heights including 0 height.
2.i - 1 - s.peek() uses the starting index where height[s.peek() + 1] >= height[tp],
 because the index on top of the stack right now is the first index left of tp with height smaller than tp's height.

 For explanation, please see http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
*/

public class Histogram{

	public static void main(String[] args) {
		Histogram h= new Histogram();
		int[] a={2,3,4};
		System.out.println(Arrays.toString(a)+" "+h.largestRectangleArea(a));
		int b={4,3,2};

		System.out.println(Arrays.toString(b)+" "+h.largestRectangleArea(b));

	}

	public int largestRectangleArea(int[] height) {
		int len=height.length,max=0;

		Stack<Integer> s= new Stack<Integer>();

		for(int i=0;i<=len;i++){
			int h=(i==len)?0;height[i];
			if(s.isEmpty()||h>=height[s.peek()]){
				s.push(i);
			}else{

				int top=s.pop();
				max=Math.max(max,height[top]*(s.isEmpty()?i:i-s.peek()-1));
				i--;
			}
		}
		return res;

	}

}