package interview.search;
/**
661. Image Smoother
DescriptionHintsSubmissionsDiscussSolution
Given a 2D integer matrix M representing the gray scale of an image,
 you need to design a smoother to make the gray scale of each cell becomes 
 the average gray scale (rounding down) of all the 8 surrounding cells and itself. 
If a cell has less than 8 surrounding cells, then use as many as you can.
*/
/*
For every element in the matrix compute the average of all the 8 surrounding cell
traverse in all 8 surrounding cell compute sum and count the number of cells
avg=sum/count;
result[i][j]=avg
*/
public class ImageSmoother {
   

    public int[][] imageSmoother(int[][] M) {
        if(M==null||M.length==0||M[0].length==0) return M;
        
        int[][] r= new int[M.length][M[0].length];
        int[][] d={{-1,0},{0,-1},{1,0},{0,1},{1,1},{-1,-1},{0,0},{1,-1},{-1,1}};
        for(int i=0;i<M.length;i++){
            
            for(int j=0;j<M[0].length;j++){
                int sum=0,count=0;
                for(int k=0;k<d.length;k++){
                    int x=i+d[k][0],y=j+d[k][1];
                        if(x>=0 && x<M.length &&y>=0 && y<M[0].length){
                            sum+=M[x][y];
                            count++;
                        }
                    
                }
                r[i][j]=sum/count;
            }
        }
        return r;
    }
    
    
}