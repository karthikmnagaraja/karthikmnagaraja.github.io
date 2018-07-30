package interview.tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
InOrder Traversal Recursive
*/
public class SerializeandDeserializeBinaryTree {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb= new StringBuilder();
        helper(root,sb);
        return sb.toString();
    }
    public void helper(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("NN").append(",");
            return;
        }
        sb.append(root.val).append(",");
        helper(root.left,sb);
        helper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q= new LinkedList<String>();
        q.addAll(Arrays.asList(data.split(",")));
        return build(q);
    }
    public TreeNode build(Queue<String> q){
        String val=q.poll();
        if(val.equals("NN")) return null;
        else{
            TreeNode node=new TreeNode(Integer.parseInt(val));
            node.left=build(q);
            node.right=build(q);
            return node;
        }
    }
}

