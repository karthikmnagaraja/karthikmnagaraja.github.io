package interview.tree;

/**
257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
*/
/**
Traverse the tree using preorder traversal. 
Add every node first and then visit left and right after reaching end remove the node from the tem list.
if the node is leaf node and no child then add the temp list to result list.
O(n) where n is the number of nodes;
*/
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result= new ArrayList<String>();
        dfs(root,new ArrayList<Integer>(),result);
        return result;
    }
    public void dfs(TreeNode node,List<Integer> temp,List<String> result){
        if(node==null) return;
        temp.add(node.val);
        if(node!=null&&node.right==null&&node.left==null){
            /**
            temp.stream().map(s->String.valueOf(s)).collect(Collectors.joining("->"))
            temp is an integer get every element value in string type and collect function is used for concating with delimter
            */

            result.add(temp.stream().map(s->String.valueOf(s)).collect(Collectors.joining("->")));
            temp.remove(temp.size()-1);
            return;
        }else{
            dfs(node.left,temp,result);
            dfs(node.right,temp,result);
        }
        temp.remove(temp.size()-1);
    }
}