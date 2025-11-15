// https://leetcode.com/problems/binary-tree-level-order-traversal/
// T(C) - O(n), S(C) - o(n)
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // bfs of tree 
        if (root == null) {
            return new ArrayList <>();
        }
        Queue <TreeNode> bfsQ = new LinkedList <>();
        
        bfsQ.offer(root);
        List <List<Integer>> res = new ArrayList <>();
        while (!bfsQ.isEmpty()){
            int size = bfsQ.size();
            List <Integer> nodeList = new ArrayList <>();
            for (int i=0; i < size; i++){
                TreeNode node = bfsQ.poll();
                nodeList.add(node.val);
                if (node.left!=null){
                    bfsQ.offer(node.left);
                }

                if (node.right!=null) {
                    bfsQ.offer(node.right);
                }
            }
            res.add(nodeList);
        }
        return res;
    }
}
