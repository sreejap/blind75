// https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return getMaxDepth (root);
    }

    public int getMaxDepth (TreeNode node) {
        if (node == null){
            return 0;
        }
        int leftD = getMaxDepth (node.left);
        int rightD = getMaxDepth (node.right);

        return Math.max(leftD, rightD) + 1;

    }
}
