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
 diameter of a tree means, I have to find longest left and longest right and then if I add both the the result should be longest among all in the tree. so it is not necessary for the diameter to pass throught the root.


 logic

 for every root find it's maximum left branch length and max right branch lengght. store the answer for every root in varaible ans

 TC - O(n) going for every branch
 SC - O(h) h is height
 */

class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);

        return diameter;

    }

    public int calculate(TreeNode root){
        if(root == null) return 0;

        int left = calculate(root.left);
        int right = calculate(root.right);

        int curr = left + right;

        diameter = Math.max(diameter, curr);

        return Math.max(left + 1 , right + 1);
    }
}
