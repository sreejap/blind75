// https://leetcode.com/problems/invert-binary-tree/
// T(C) - o(n)
// S(C) - o(h) height of the tree...
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree (root.left);
        TreeNode right = invertTree (root.right);

        root.left = right;
        root.right = left; // invert for the child nodes and then flip them..
        return root;        
    }

  public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;  // flip the nodes and then call on child nodes

        invertTree (root.left);
        invertTree (root.right);
        return root;
    }
}
