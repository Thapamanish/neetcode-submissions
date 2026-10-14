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

 invert means we have to mirror the tree, in short left to right and right to left sub tree

TC -> O(n)
SC -> O(h)
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        
        TreeNode temp = invertTree(root.left);
        root.left =  invertTree(root.right);
        root.right = temp;

        return root;
    }
}
