package interview.array;
//Sort all characters in a string
public class Search2DMatrix{
public static void main(String args[]){
         
        int[] inputArr = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        Search2DMatrix mms = new Search2DMatrix();
        System.out.print(mms.searchMatrix(inputArr,3);
        
    }

public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return false;
        int i=0,j=matrix[0].length-1;
        while(i<matrix.length&&j>=0){
            int value=matrix[i][j];
            if(value==target) return true;
            else if(value<target) i++;
            else if(value> target)j--;
        }
        return false;
    }
}