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

 find the depth of the tree.

 basically find how deep the node goes

 we need to see if which goes deep left node or right node, reutrn the max, do it recursively
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}
