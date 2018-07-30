package interview.search;
/**
529. Minesweeper

Let's play the minesweeper game (Wikipedia, online game)!

You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

If a mine ('M') is revealed, then the game is over - change it to 'X'.
If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.
Example 1:
Input: 

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

Output: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:

Example 2:
Input: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Click : [1,2]

Output: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:

*/
/**
Thoughts:
1.If the click correspont value of board is 'M' then change the value to 'X'
2.If value of click is not 'E' Otherwise count the number of adjacent mines in all 4 directions;
3.count==0 then change value to blank then repeat step 2
4.count!=0 means when mines are found then replace the value with the number of mines(count) with the value of the matrix;
Time Complexity:O(mn)
Space Complexity:O(1); 
*/
class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x=click[0],y=click[1];
        if(board[x][y]=='M'){
            board[x][y]='X';
                return board;
        }
        
        dfs(board,x,y);
        return board;
        
    }
    int[] dx = {-1, 0, 1, -1, 1, 0, 1, -1};
    int[] dy = {-1, 1, 1, 0, -1, -1, 0, 1};
    public void dfs(char[][]b,int x, int y){
        if(x>=b.length||x<0||y<0||y>=b[x].length||b[x][y]!='E') return;
        int numberOfMines=countOfMines(b,x,y);
        if(numberOfMines==0){ 
             b[x][y]='B';
           for(int i=0;i<8;i++){
                int x1=x+dx[i],y1=y+dy[i];
                if(x1>=b.length||x1<0||y1<0||y1>=b[x1].length) continue;
                dfs(b,x1,y1);
            }
        }else{
            b[x][y]=(char)(numberOfMines+'0');
        }
    }
    public int countOfMines(char[][]b,int x, int y){
        
        int count=0;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){ 
                int dx=x+i,dy=y+j;
                if(dx>=b.length||dx<0||dy<0||dy>=b[dx].length) continue;
                if(b[dx][dy]=='M'||b[dx][dy]=='X') count++;
            }
        }
        return count;
    }
    private int getNumsOfBombs(char[][] board, int x, int y) {
        int num = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i, ny = y + j;
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length)    continue;
                if (board[nx][ny] == 'M' || board[nx][ny] == 'X') {
                    num++;
                }
            }
        }
        return num;
    }
}