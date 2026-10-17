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
 for valid bst root should be > left and < right and it should be same recrusively for the branches
 as well
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, int minVal, int maxVal) {
        if (root == null)
            return true;

        if (root.val <= minVal || root.val >= maxVal)
            return false;

        return isValid(root.right, root.val, maxVal) && isValid(root.left, minVal, root.val);
    }
}
