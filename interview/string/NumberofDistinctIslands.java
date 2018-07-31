package interview.string;

//694. Number of Distinct Islands
public class NumberofDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Set<String> result= new HashSet<String>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                
                if(grid[i][j]==1){
                    StringBuilder sb= new StringBuilder();
                    dfs( i, j,grid , sb,'s');
                    result.add(sb.toString());
                }
            }
        }
        return result.size();
    }
   public void dfs(int x,int y,int[][] grid ,StringBuilder sb, char ch){
       if(x<0||x>grid.length-1||y<0||y>grid[x].length-1||grid[x][y]!=1) return;
       grid[x][y]=0;
       sb.append(ch);
       dfs( x+1, y,grid , sb,'d');
       dfs( x, y+1,grid , sb,'r');
       dfs( x, y-1,grid , sb,'l');
       dfs( x-1, y,grid , sb,'u');
       sb.append('b');
   }
    
}