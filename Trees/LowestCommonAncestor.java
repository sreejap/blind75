// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// T(C) - O(N) 
// S(C) - The recursion stack can go as deep as the height of the tree H, Worst case (skewed tree): O(N), Best case (balanced tree): O(log N)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // this is a binary tree..we can't do left right because this is not BST

        if (root == null) {
            return root;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor (root.left, p,q);

        TreeNode right  = lowestCommonAncestor (root.right, p,q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }
        
        return root;
    }
}
