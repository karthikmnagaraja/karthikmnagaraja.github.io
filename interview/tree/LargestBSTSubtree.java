package interview.tree;
/**
Problem States that given binary tree find the largest bst.
1. First check that for every node is valid BST then return count the nodes below that.
2. If its not a BST check if the largest bst in left subtree  and right sub tree
3. return the max(left,right)
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
public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if(root==null) return 0;
        if(isValid(root,Long.MIN_VALUE,Long.MAX_VALUE)){
            return count(root);
        }
        int left=largestBSTSubtree(root.left);
        int right=largestBSTSubtree(root.right);
        return Math.max(left,right);
        
    }
    public int count(TreeNode root){
        if(root==null) return 0;
        return count(root.left)+count(root.right)+1;
    }
    public boolean isValid(TreeNode root, long min, long max){
        if(root==null) return true;
        if(root.val<=min||root.val>=max) return false;
        return isValid(root.left,min,root.val)&&isValid(root.right,root.val,max);
    }
}