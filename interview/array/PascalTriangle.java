package interview.array;

public class PascalTriangle {

/**
https://leetcode.com/problems/pascals-triangle/description/
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
/**
Thoughts:
loop through 0->numRows
every time add 1 at the starting of the list
if 
*/

public static void main(String args[]){
    PascalTriangle p= new PascalTriangle();
    List<List<Integer>> result= p.generate(5);

    for(List<Integer> list: result)
        System.out.println(list.toString());
}
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        List<Integer> first=  new ArrayList<Integer>();
        for(int i=0;i<numRows;i++){
            first.add(0,1);
            for(int j=1;j<first.size()-1;j++){
               
                first.set(j,first.get(j)+first.get(j+1));
            }
            result.add(new ArrayList<Integer>(first));
        }
        return result;
    }
    
    
}