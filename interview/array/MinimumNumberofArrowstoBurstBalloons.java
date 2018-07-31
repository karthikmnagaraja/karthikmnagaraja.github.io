package interview.array;

//452. Minimum Number of Arrows to Burst Balloons same as 646
// Find non overlapping intervals so you can shoot maximum number of ballons with minimum number of arrows
public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] pairs) {
        if(pairs.length==0) return 0;
       Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int end=pairs[0][1], len=1;
        System.out.println(Arrays.deepToString(pairs));
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>end){
                len++;
                end=pairs[i][1];
            }
        }
        return len; 
    }
}