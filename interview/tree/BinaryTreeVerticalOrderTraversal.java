package interview.tree;

/**
            Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
Thoughts:
Vertical order:
if evel of the root is level
level of left of root child is level -1
level of right of the root child is level+1

since the return type list 
first elemnt of the result will be the left most element and last element of the result will be right most element.
 
 Step 1 compute the level of left most child and right most child let it be min and max by this we get to size of the resul
 Step 2 create a result and add the number of elements in the range[min,max]
 Step 3 Do a bfs or level order traversal but mainatin an extra queue to track the level of every node.
 whenever you push a node to node queue, push the level of the node too. 
 when you poll the node, get the value and add to the result list where index is obtained by polling the level queue
 level-min since min will be the index of left most element
Space Complexity: O(n);
Time complexity: O(n)
*/
public class BinaryTreeVerticalOrderTraversal{

    private int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
         List<List<Integer>> result= new ArrayList<List<Integer>>();
        if(root==null) return result;
        range(root,0);
        
        for(int i=min;i<=max;i++) result.add(new ArrayList<>());
        
        
        return pathHelper(root,result);
        
    }
    public List<List<Integer>> pathHelper(TreeNode root,List<List<Integer>> result){
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        Queue<Integer> l=new LinkedList<Integer>();
        q.offer(root);
       l.offer(0);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                
                int level=l.poll();
                result.get(level-min).add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                    l.offer(level-1);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    l.offer(level+1);
                }
            }
        }
        return result;
               
    }
    public void range(TreeNode node, int level){
        if(node==null) return;
        min=Math.min(min,level);
        max=Math.max(max,level);
        range(node.left,level-1);
       range(node.right,level+1);
       
        
    }
}