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
 for this question we have to find that for any BT left and right subtree doesn't differ more than
 one

 we can get left and right max hiehgt then calculate the difference and if it is greater than 1
 return false;
 */

class Solution {
         boolean isTrue = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
   
        heightDifference(root);

        return isTrue;
    }

    public int heightDifference(TreeNode root) {
        if (root == null)
            return 0;

        int left = heightDifference(root.left);
        int right = heightDifference(root.right);



        if (Math.abs(left - right) > 1)
            isTrue = false;

        System.out.println(isTrue);

        return 1 + Math.max(left, right);
    }
}
