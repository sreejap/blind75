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
        if (root == null) {
            return root;
        }
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        
        // if I feel overwhelmed, start with making it simple first
        // check both sides
        // are both on the right or left
        if (pVal > parentVal && qVal > parentVal) {
            // solve by hand, make it simple
            return lowestCommonAncestor(root.right,p,q);
        }

        else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor (root.left,p,q);
        }else {
            return root; // it is given p,q are in the tree...
        }
    }
}
