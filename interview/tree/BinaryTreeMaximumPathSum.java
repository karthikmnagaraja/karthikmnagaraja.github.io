package interview.tree;


public class BinaryTreeMaximumPathSum {
    private int max=Integer.MIN_VALUE;
     public int maxPathSum(TreeNode root) {
         maxPathSumhelper(root);
         return root==null?Integer.MIN_VALUE:max;
     }
    public int maxPathSumhelper(TreeNode root) {
        if(root==null) return 0;
        int lmax=Math.max(0,maxPathSumhelper(root.left));
        int rmax=Math.max(0,maxPathSumhelper(root.right));
        max=Math.max(max,root.val+lmax+rmax);
        return root.val+Math.max(lmax,rmax);
    }
    
}