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

 we need to find if valid bst

 what we know

 root.val > root.left.val
 root.val < root.right.val

 but we need to see for the sub tree wee need to maintain other branch as well

 what i mean

 for a left subtree we know that left should not be greater than root but we need to make sure as
 level increases we lose track of what value the ancestor is limmting

 like for the left sub tree

 values can go form val < root till infinity

 for right sub tree
 val > root till infinity

 on antoher level


 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root.left, root.val, Integer.MIN_VALUE)
            && isValid(root.right, Integer.MAX_VALUE, root.val);
    }

    public boolean isValid(TreeNode root, int max, int min) {
        if(root == null) return true;
        
        if(root.val >= max || root.val <= min) return false;

        return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
    }
}
