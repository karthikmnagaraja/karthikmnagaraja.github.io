package interview.tree;

//863. All Nodes Distance K in Binary Tree
/** this is simlar to closest leaf node problem

Main catch is doing 2 traversals for same problem.

Find the nodes at distance k  in a binary tree with agive tree node
1. Do dfs to find the node and create a mapping child->parent so you can traverse using parent pointer.
2. Do bfs(level order) from the target node in left subtree, right subtree and parent level until k levels.
 */
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result=new ArrayList<Integer>();
        if(root==null||target==null) return result;
        Map<TreeNode,TreeNode> map= new HashMap<TreeNode,TreeNode>();
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        Set<TreeNode> set= new HashSet<TreeNode>();
        TreeNode kNode=dfs(root,target,map);
        q.offer(kNode);
        set.add(kNode);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(K==0) result.add(node.val);
                if(map.containsKey(node)&& set.add(map.get(node))){
                    q.offer(map.get(node));
                }
                if(node.left!=null &&set.add(node.left)){
                    
                    q.offer(node.left);
                }
                if(node.right!=null && set.add(node.right)){
                    
                    q.offer(node.right);
                }
            }
            K--;
            if(K<0) break;
        }
        return result;
    }
    TreeNode  dfs(TreeNode root,TreeNode target,Map<TreeNode,TreeNode> map){
        if(root==null|| root.val==target.val) return root;
        if(root.left!=null){
            map.put(root.left,root);
           TreeNode left= dfs(root.left,target,map);
            if(left!=null) return left;
            
        }
        if(root.right!=null){
            map.put(root.right,root);
           TreeNode right= dfs(root.right,target,map);
            if(right!=null) return right;
            
        }
        return null;
    }
}