package interview.tree;

/**
Inorder but in descnding order so that you can add the value to left tree nodes.
*/
public class ConvertBsttoGreaterTree {
   int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
       if(root==null) return root;
        convertBST(root.right);
        root.val+=sum;
        sum=root.val;
        convertBST(root.left);
        return root;
    }
    
    
   
}