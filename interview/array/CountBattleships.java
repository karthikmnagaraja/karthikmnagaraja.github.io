package interview.array;
/*

Thoughts:
Count x when there is no x to left([i][j-1]) of it and above it([i-1][j])
Space Complexity=O(1)
Time Complexity=O(mn) 1 pass
*/

public class CountBattleships{
	
	 public int countBattleships(char[][] b) {
        int m=b.length;
        int n=b[0].length;
        int count=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(b[i][j]=='.') continue;
                if((i>0&&'X'==b[i-1][j])||(j>0&&'X'==b[i][j-1])) continue;
              
                count++;
            }
        return count;
    }
    public static void main(String[] args) {
    	char[][] b={{"X",".",".","X"},{".",".",".","X"},{".",".",".","X"}};
    	CountBattleships c= new CountBattleships();
    	System.out.println(c.countBattleships(b));
    }

}