package interview.search;
/*
200. Number of Islands
DescriptionHintsSubmissionsDiscussSolution
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

/*
Thoughts:
1.Traverse through the matrix when you find 1 go to step 2 and increase the counter number of islands
2.Do dfs search for the neighbours whose value is 1 and change the value to 0 so that it wont be visited again.
3.Return the counter value.
Time Complexity:O(mn)
Space Complexity:O(1); 
*/

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int result=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++)
                if(grid[i][j]=='1') {
                    dfs(grid,i,j);
                    result++;
                }
        return result;
    }
    public void dfs(char[][] g,int i,int j){
        if(i<0||j<0||i>=g.length||j>=g[i].length||g[i][j]!='1') return ;
        g[i][j]='0';
        
        dfs(g,i-1,j);
        dfs(g,i+1,j);
        dfs(g,i,j-1);
        dfs(g,i,j+1);
       
    }
   
}
