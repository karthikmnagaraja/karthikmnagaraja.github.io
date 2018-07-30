package interview.stacks;
/**
173. Binary Search Tree Iterator
DescriptionHintsSubmissionsDiscussSolution
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/
/**
Thoughts:
Tree must be sorted in ascending order so the tree must be traversed in preorder.
1.While intiating the tree push all the left children until you wont find an left child to the stack. 
Now the stack top will be the leat value elemnt in the tree.
2. During push operation. Pop the top element in the stack and push all the right child's as we did in step 1. and return the poped element value.
3.hasNext is just check if stack contains any element or not.


*/
public class BinarySearchTreeIterator{
	
	Stack<TreeNode> s= new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        push(root);
    }
    
    public void push(TreeNode node){
        while(node!=null){
            s.push(node);
            node=node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node=s.pop();
        push(node.right);
        return node.val;
    }
}