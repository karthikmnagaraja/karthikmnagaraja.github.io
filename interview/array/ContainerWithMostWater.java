package interview.array;
/**
11. Container With Most Water
Max Area of water contained= width*depth;
Approach 2 pointer approach
1. left=0, right=end of array
2. right-left=width but depth is Math.min(height[left],height[right])

*/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height.length==0) return 0;
        int left=0,right=height.length-1;
        int max=0;
        while(left<right){
             max=Math.max(max,Math.min(height[right],height[left])* (right-left));
            if(height[left]<height[right]) left++;
            else right--;
        }
        return max;
    }
}