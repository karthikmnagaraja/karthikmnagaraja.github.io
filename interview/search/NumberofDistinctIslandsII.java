package interview.search;
public class NumberofDistinctIslandsII {
    public int numDistinctIslands2(int[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        Set<Integer> result= new HashSet<Integer>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                List<int[]> cells= new ArrayList<int[]>();
                dfs(grid,i,j,cells);
                result.add(hash(cells));
                }
        }
        }
        return result.size();
        
    }
    public void dfs(int[][] g, int i, int j, List<int[]> cells){
        if(i<0||i>g.length-1||j<0||j>g[i].length-1||g[i][j]!=1) return;
        cells.add(new int[]{i,j});
        g[i][j]=8;
        dfs(g,i-1,j,cells);
        dfs(g,i+1,j,cells);
        dfs(g,i,j-1,cells);
        dfs(g,i,j+1,cells);
        
    }
    public int hash(List<int[]> cells){
        int hash=0;
        for(int i=0;i<cells.size();i++){
            for(int j=i+1;j<cells.size();j++){
            int dx=cells.get(i)[0]-cells.get(j)[0];
                int dy=cells.get(i)[1]-cells.get(j)[1];
                if(dx==0||dy==0) hash+=21*(dx*dx+dy*dy);
                else hash+=31*(dx*dx+dy*dy);
        }
        }
        return hash;
    }
    
   

    
}