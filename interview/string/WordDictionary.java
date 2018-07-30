package interview.string;
/**
211. Add and Search Word - Data structure design
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
Companies Facebook

Related Topics Backtracking,trie

Similar Questions 
Implement Trie (Prefix Tree)Prefix and Suffix Search
*/
/**
Main Idea is to store all the words in a trie through insert method and then facilate search on the stored words from the trie.

Datastructure to store: Trie since it wil be very efficient for searching

Insert: Add the word to the trie

Search: 
Word without '.': It is straight forward search in the trie; if present return true or not false.

When the for contain '.' when need to loop through all the childreen check if the word is available.

So we use backtracking approach.

Base case
1. if we have reached the end of the searchword then we have to check if the do we search word in the trie at the point of time.
2. if the char in the search word is not '.' the then check  in the trie does contain the children for the node or return false. and continue the recursive search for next character.
3. if char is '.' check if a-z node in trie child node exist make a recursive search for next character. if found return true;


Insert
*/
class WordDictionary {
    public static class TrieNode{
        TrieNode[] children;
        char ch;
        boolean isEnd;
        public TrieNode(char ch){
            this.ch=ch;
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root=new TrieNode(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node= this.root;
        for(char c:word.toCharArray()){
            int i=c-'a';
            if(node.children[i]==null)
                node.children[i]=new TrieNode(c);
            node=node.children[i];
        }
        node.isEnd=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node= this.root;
        return helper(node,word.toCharArray(),0);
    }
    public boolean helper(TrieNode node,char[] chr,int pos){
        if(pos==chr.length) return node.isEnd;
        else if (chr[pos]!='.') return (node.children[chr[pos]-'a']!=null
                                        &&helper(node.children[chr[pos]-'a'],chr,pos+1));
        else{
            for(int i=0;i<26;i++){
                if(node.children[i]!=null && helper(node.children[i],chr,pos+1)) return true;
            }
            
        }
         return false;                             
    }
    /*
    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) return !node.item.equals("");   
        if (chs[k] != '.') {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }*/
    
    
}