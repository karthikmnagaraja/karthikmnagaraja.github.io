package interview.string;
/**
606. Construct String from Binary Tree
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
*/

/**
Thoughts:
Looking By the example 
1.we can assume that if right node is null then dont include empty braces and left node is present.
2.we can assume that if left node is null then  include empty braces and right node is present.
3. If Both is absent then dont inlcude both.

Other than above conditions : Its plain old inorder traversal, before traversing child add open brace and after that close brace. incase of node is null just an empty space. and return.
Space Complexity: O(n)
Time Complexity: O(n) since n nodes should be processed to form the result.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ConstructStringfromBinaryTree {
    public String tree2str(TreeNode t) {
        StringBuilder sb= new StringBuilder();
        convert(t,sb);
        return sb.toString();
    }
    public void convert(TreeNode t, StringBuilder sb){
        if(t==null){ sb.append(""); return;}
        sb.append(t.val);
       if(t.left!=null||t.right!=null){
            sb.append("(");
            convert(t.left,sb);
            sb.append(")");
  
        if(t.right!=null){
            sb.append("(");
            convert(t.right,sb);
            sb.append(")");
        }
       }
        
    }
}