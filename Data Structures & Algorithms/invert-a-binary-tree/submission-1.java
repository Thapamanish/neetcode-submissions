/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

 PROBLEM - invert a binary tree

 DO - swap right and left sub tree till the leaf of each subbranch


 we can use dfs to do it, we can do it in two ways

 1. revert as we go 
 2. revert as we come back



2.

 right = invertTree(root.right)
left = INvertTree(root.left)

root.left = right
root.right = left


not sure about how to do as we go down
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
