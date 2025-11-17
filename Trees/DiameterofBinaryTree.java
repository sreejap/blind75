// https://leetcode.com/problems/diameter-of-binary-tree/
// T(C) - O(n), S(C) - O(n)
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
 */
class Solution {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        if (root == null) {
            return 0;
        }
        longestPath (root);
        return diameter;
    }

    public int longestPath (TreeNode node){
        if (node == null){
            return -1;
        }

        int leftH = longestPath (node.left);
        int rightH = longestPath (node.right);

        diameter = Math.max (diameter, leftH + rightH + 2);
        return Math.max (leftH, rightH) + 1;
    }
}
