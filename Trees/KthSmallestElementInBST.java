//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// T(C) - O(n)
// S(C) - O(k + h), Best case: balanced BST → O(k + log n), Worst case: skewed BST → O(k + n)

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
    public int kthSmallest(TreeNode root, int k) {

        List <Integer> res = new ArrayList <>();
        helper (root,k,res);
        return res.get(k-1);        
    }

    public void helper (TreeNode node, int k, List <Integer> res){

        if (node == null) {
            return;
        }

        if (res.size()==k){
            return ;
        }

        helper (node.left, k, res);
        res.add(node.val);
        helper (node.right, k, res);
    }
}
