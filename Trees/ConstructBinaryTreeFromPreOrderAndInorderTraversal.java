// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    int preOrderIndex;
    Map <Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        indexMap = new HashMap <>();
        for (int i=0; i < inorder.length; i++){
            indexMap.put(inorder[i],i);
        }

        TreeNode root = buildTree (preorder,0,preorder.length-1);
        return root;
    }

    public TreeNode buildTree (int[] preorder, int left, int right) {
        if (left > right) {
            return null; 
        }

        TreeNode node = new TreeNode (preorder[preOrderIndex++]); // get the first node which is root
        int rootIndex = indexMap.get(node.val);
        node.left = buildTree (preorder,left,rootIndex-1);
        node.right = buildTree (preorder, rootIndex+1, right); 
        return node;
    }
}
