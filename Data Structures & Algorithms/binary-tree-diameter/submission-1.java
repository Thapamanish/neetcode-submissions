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
 We need to find the longest length in a tree between two leaf node. it could go through root or not
 so at every node we need to have max left and max right.
 */

class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
      

        longest(root);

        return ans;
    }

    public int longest(TreeNode root) {
          if (root == null)
            return 0;
        int left = longest(root.left);
        int right = longest(root.right);

        ans = Math.max(ans, left + right);

        return 1 + Math.max(left, right);
    }
}
