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
left and right should not be more than 1

so we want max of left and right



 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isValid(root) == -1 ? false : true;
    }

    private int isValid(TreeNode root){
        if(root == null) return 0;

        int left = isValid(root.left);
        int right = isValid(root.right);

        if(left == -1 || right == -1) return -1;

        return Math.abs(right - left) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
