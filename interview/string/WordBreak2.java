package interview.string;
 import java.util.*;
public class WordBreak2 {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String str:words){
            this.insert(str,root);
        }
        List<String> result= new ArrayList<String>();
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++)
                dfs(board,i,j,root,result);
        
        return result;
    }
    
    public void dfs(char[][] board,int i,int j,TrieNode node,List<String> result){
        char c=board[i][j];
        if(c=='#'||node==null||node.children[c-'a']==null) return;
        node=node.children[c-'a'];
        if(node!=null&&node.str!=null&&node.str.length()>0){
            result.add(node.str);
            node.str="";
        }
        
        board[i][j]='#';
        if(i>0)dfs(board,i-1,j,node,result);
        if(i<board.length-1)dfs(board,i+1,j,node,result);
        if(j>0)dfs(board,i,j-1,node,result);
        if(j<board[i].length-1)dfs(board,i,j+1,node,result);
        board[i][j]=c;
        return;
    }
    
    public static class TrieNode{
        TrieNode[] children;
        String str;
        public TrieNode( ){
            this.children= new TrieNode[26];
            this.str="";
        }
    }
    public void insert(String word,TrieNode root) {
        TrieNode node =root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(node.children[index]==null){
                node.children[index]=new TrieNode();
            }
            node=node.children[index];
        }
        node.str=word;
    }

    public static void main(String[] args) {
        char[][] board={
  {'o','a','a','n'},
  {'e','t','a','e'},
  {'i','h','k','r'},
  {'i','f','l','v'}
    };
    String[] words = {"oath","pea","eat","rain"};

    WordBreak2 w= new WordBreak2();
    List<String> result=w.findWords(board,words);
    System.out.println(result);


    }
}