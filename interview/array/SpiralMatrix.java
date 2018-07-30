package interview.array;

/**
top,left---r
|			|
|			|
bottom----	|
*/
public  class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> r= new ArrayList<Integer>();
        if(m.length==0||m[0].length==0) return r;
        int top=0,bottom=m.length-1;
        int left=0,right=m[0].length-1;
        while(true){
            for(int i=left;i<=right;i++)r.add(m[top][i]);
            top++;
            if(left>right||top>bottom) break;
            for(int i=top;i<=bottom;i++)r.add(m[i][right]);
            right--;
            if(left>right||top>bottom) break;
            for(int i=right;i>=left;i--)r.add(m[bottom][i]);
            bottom--;
            if(left>right||top>bottom) break;
            for(int i=bottom;i>=top;i--)r.add(m[i][left]);
            left++;
        }
        return r;
    }
}