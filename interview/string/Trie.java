package interview.string;

public class Trie {
    public static class TrieNode{
        TrieNode[] children;
        String str;
        
        public TrieNode( ){
            
            this.children= new TrieNode[26];
            
        }
        
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root=new TrieNode();
    
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node =this.root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(node.children[index]==null){
                node.children[index]=new TrieNode();
            }
            node=node.children[index];
        }
        node.str=word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
         TrieNode node =this.root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(node.children[index]==null){
                return false;
            }
            node=node.children[index];
        }
        return node.str.length()==word.length();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
         TrieNode node =this.root;
        for(int i=0;i<prefix.length();i++){
            int index=prefix.charAt(i)-'a';
            if(node.children[index]==null){
                return false;
            }
            node=node.children[index];
        }
        return true;
    }
    public List<String> traverse(){
        List<String> result= new ArrayList<String>();
        preOrder(this.root,result);
        return result;
    }

    public void preOrder(TrieNode node, List<String> result){
        if(node==null) return;
        if(node.str.length()!=0) {
            result.add(node.str);
            
        }
        for(int i=0,i<26;i++){
            preOrder(node.children[i],result);
        }

    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        String arr[] = { "abc", "xyz", "abcd", "bcd", "abc" };
        for(String str:arr){
            trie.insert(str);
        }
        List<String> result=trie.traverse();
        System.out.println(result.toString());
    }
}