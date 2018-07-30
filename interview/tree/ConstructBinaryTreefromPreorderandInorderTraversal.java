package interview.math;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ConstructBinaryTreefromPreorderandInorderTraversal {
    int index=-1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         Map<Integer,Integer> map= new HashMap<Integer,Integer>();
        
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        index=0;
        return util(inorder,preorder,0,preorder.length-1,map);
    }
     TreeNode util(int[] inorder,int[]preorder, int start,int end,Map<Integer,Integer> map){
        if(index>preorder.length|| start>end) return null;
         int idx=map.get(preorder[index]);
        TreeNode node= new TreeNode(preorder[index]);
        index++;
         node.left=util(inorder,preorder,start,idx-1,map);
        node.right=util(inorder,preorder,idx+1,end,map);
        
        return node;
        
    }
}