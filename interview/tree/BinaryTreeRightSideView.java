package interview.tree;
/**
199. BinaryTreeRightSideView
DescriptionHintsSubmissionsDiscussSolution
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
*/
/**
THoughts:
Do level order traversal but in reverse order inorder to find the right most node at each level.
At each level add only the first node since first node is the right most element added the the queue while traversing the parent level.

Time Complexity:O(N) where n is the number of node in the treee
Space Complexity:O(n) we have to use a queue to stroe the order of traversal;
*/

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();
        List<Integer> result= new ArrayList<Integer>();
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
            TreeNode node=q.poll();
                if(i==0)result.add(node.val);
                if(node.right!=null) q.offer(node.right);
                if(node.left!=null) q.offer(node.left);
            }
        }
        return result;
    }
}