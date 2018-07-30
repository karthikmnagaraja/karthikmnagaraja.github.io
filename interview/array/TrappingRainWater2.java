package interview.array;

/**
LeetCode: https://leetcode.com/problems/trapping-rain-water-ii/description/
Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
Example:
Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]
Return 4.
*/
/*
Thoughts:
1. Each spot needs to know the wall height from 4 directions
2. The water height of current spot is determined by the lowest of the 4 walls
=> Use Priority queue to store position sorted by height.
Go layer by layer: outside layer first, then process queue => BFS

Time: O(mn), queue with check through all items
Space: O(mn), queue size
*/
public class TrappingRainWater2{


    public class Cell{
        int row,col,height;
        public Cell(int r,int c,int h){
            row=r;col=c;height=h;
        }
    }
	public static void main(String args[]){
         
        int[] inputArr = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater mms = new TrappingRainWater();
        int result=mms.trap(inputArr);
        
            System.out.print(result);
          
    }

   public int trapRainWater(int[][] heightMap) {
        if(heightMap==null||heightMap.length==0|| heightMap[0].length==0) return 0;

        int res=0;
        PriorityQueue<Cell> pq= new PriorityQueue<Cell>((a,b)->a.height-b.height);
        
        int m=heightMap.length,n=heightMap[0].length;
        boolean[][] visited= new boolean[m][n];

        for(int i=0;i<m;i++)
              for(int j=0;j<n;j++)
                if(i==0||j==0||i==m-1||j=n-1){
                    visited[i][j]=true;
                    pq.offer(new Cell(i,j,height[i][j]) );
                 }
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){
            Cell=pq.poll();
            for(int[] dir: dirs){
                int row=dir[0]+cell.row;
                int col=dir[1]+cell.column;
                if(row>0 && row<m &&col>0&&col<n&&!visited[row][col]){
                    visited[row][col]=true;
                    res+=Math.max(0,cell.height-height[row][col]);
                    pq.offer(new Cell(row,col,height[row][col]+cell.height));
                }
            }
        }
        
        return res;
    }
}