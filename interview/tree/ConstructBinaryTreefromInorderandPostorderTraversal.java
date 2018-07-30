pacakge interview.tree


public class ConstructBinaryTreefromInorderandPostorderTraversal {
    int index=-1;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        Map<Integer,Integer> map= new HashMap<Integer,Integer>();
        
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        index=postorder.length-1;
        return util(inorder,postorder,0,postorder.length-1,map);
        
            
        
    }
    
    TreeNode util(int[] inorder,int[]postorder, int start,int end,Map<Integer,Integer> map){
        if(index<0|| start>end) return null;
         int idx=map.get(postorder[index]);
        TreeNode node= new TreeNode(postorder[index]);
        index--;
        node.right=util(inorder,postorder,idx+1,end,map);
        node.left=util(inorder,postorder,start,idx-1,map);
        return node;
        
    }
}