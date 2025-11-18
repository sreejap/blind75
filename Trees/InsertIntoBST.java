// basic question - not blind 75
// T(c) - O(H) - H = logN in best case N in case BST is skewed
// S(C) - o(H)
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode (val);
        }
        // since we update the tree when we insert node, we have to put the updated tree back
        // that's why we assign here, otherwise the new nodes are lost
      // You assign the recursive result back to root.left or root.right because: The recursive call inserts the value somewhere deeper. It returns the new root of that subtree after insertion. You must reconnect that updated subtree back to the parent.

Otherwise the inserted node is lost.
        if (val > root.val) {
            root.right = insertIntoBST (root.right, val);
        }

        else {
            root.left = insertIntoBST (root.left, val);
        }
        return root;
        
    }
}
