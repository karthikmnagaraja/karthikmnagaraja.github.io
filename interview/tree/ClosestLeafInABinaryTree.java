package interview.tree;
//742. Closest Leaf in a Binary Tree
/**
Find the nearest leaf node in a binary tree with agive value of a tree node
1. Do dfs to find the node and create a mapping child->parent so you can traverse using parent pointer.
2. Do bfs from the target node in left subtree, right subtree and parent level.
 */
public class ClosestLeafInABinaryTree {
    public int findClosestLeaf(TreeNode root, int k) {
        if(root==null) return 0;
        Map<TreeNode,TreeNode> map= new HashMap<TreeNode,TreeNode>();
        TreeNode n=dfs(root,map,k);
        Set<TreeNode> visited = new HashSet<TreeNode>(); 
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.add(n);
        visited.add(n);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left==null &&node.right==null) return node.val;
            if(node.left!=null && visited.add(node.left)){
                q.offer(node.left);
            }
            if(node.right!=null && visited.add(node.right)){
                q.offer(node.right);
            }
            if(map.containsKey(node)&&visited.add(map.get(node))){
                q.offer(map.get(node));
            }
            
        }
        return -1;
    }
    
    TreeNode dfs(TreeNode node,Map<TreeNode,TreeNode> map,int k){
        if(node==null|| node.val==k) return node;
        if(node.left!=null){
            map.put(node.left,node);
            TreeNode left=dfs(node.left,map,k);
            if(left!=null) return left;
        }
        if(node.right!=null){
            map.put(node.right,node);
             TreeNode right=dfs(node.right,map,k);
            if(right!=null) return right;
        }
        return null;
    }
}

