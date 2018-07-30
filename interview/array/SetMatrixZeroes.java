
/**
73. Set Matrix Zeroes
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
*/

/*
Thoughts:
If first col/row is zero


*/

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean fc=false,fr=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0)
                {
                    if(i==0) fr=true;
                    if(j==0) fc=true;
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                } 
            }
        }
       
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][0]==0||matrix[0][j]==0)
                {
                    matrix[i][j]=0;
                } 
            }
        }
       
        if(fr)
            for(int j=0;j<matrix[0].length;j++)matrix[0][j]=0;
                    
        if(fc)
            for(int i=0;i<matrix.length;i++)matrix[i][0]=0;
        
        
        
    }
}