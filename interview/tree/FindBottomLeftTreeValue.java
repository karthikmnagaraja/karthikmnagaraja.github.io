package interview.tree;

/**
513. FindBottomLeftTreeValue
DescriptionHintsSubmissionsDiscussSolution
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
*/
/**
THoughts:
Do level order traversal from left to right at each level
At each level set first node ad result since first node is the left most element  at the level added the the queue while traversing the parent level.

Time Complexity:O(n) where n is the number of node in the treee
Space Complexity:O(n) we have to use a queue to stroe the order of traversal+ result set;
*/

class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
      
        if(root==null) return 0;
        int result= 0;
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
            TreeNode node=q.poll();
                if(i==0)result=node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                
            }
        }
        return result;
   
    }
}