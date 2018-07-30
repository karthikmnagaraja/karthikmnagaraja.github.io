package interview.tree;
/**
Path sum mean= sum of value of nodes from root to leaf nodes


**/
public class HasPathSum{

public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null&&sum-root.val==0 ) return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
        
        
        
    }
  }