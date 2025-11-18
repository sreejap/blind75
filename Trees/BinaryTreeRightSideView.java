// https://leetcode.com/problems/binary-tree-right-side-view/
// T(C) - O(n), S(C) - O(Diameter of tree)
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
    public List<Integer> rightSideView(TreeNode root) {
        
        if (root == null) {
            return new ArrayList <Integer>();
        }
        List <Integer> rightSide = new ArrayList <>();

        Queue <TreeNode> bfsQ = new LinkedList <>();

        bfsQ.offer (root);

        while (!bfsQ.isEmpty()) {
            int qSize = bfsQ.size ();

            for (int i=0; i < qSize; i++){
                TreeNode n = bfsQ.poll ();
                if (i == qSize-1) {
                    rightSide.add(n.val);
                }

                if (n.left!=null) {
                    bfsQ.offer(n.left);

                }

                if (n.right!=null) {
                    bfsQ.offer (n.right);
                }
            }
        }

        return rightSide;
    }
}
