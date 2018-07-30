package interview.search;
/*
270. Closest Binary Search Tree Value
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
*/
/*
Thoughts:
Approach: Binary search on tree
1. Store closest value as root node since we are yet to determine that root has child or not.
2. Check the difference between (closest.val-target) and (root.val-target)
if its root is near value the difference between the root.val is very close to target then update closest is root
else find the next node by if the root.val is less then target to find the more near node to target traverse right else left;
O(log(h)) h is the height of the tree

Try to write an recursive solution for the same problem
*/


public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        TreeNode closest=root;
        while(root!=null){
            if(Math.abs(closest.val-target)>=Math.abs(root.val-target))
                closest=root;
            root=root.val<target?root.right:root.left;
        }
        return closest.val;
    }
}