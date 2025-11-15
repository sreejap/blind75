/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
// https://leetcode.com/problems/clone-graph/
// T(c) - o(n+m) n : number of nodes, m number of edges
// S(c) - o(n)- Space Complexity: O(N). This space is occupied by the visited hash map and in addition to that, space would also be occupied by the recursion stack since we are adopting a recursive approach here. 
// The space occupied by the recursion stack would be equal to O(H) where H is the height of the graph. Overall, the space complexity would be O(N).
// intuition: check if the node is cloned by looking into the visited map
// when adding neighbors, add clone of nbrs, not creating directly
// map syntax is containsKey
// for (Node n : neighbors){ // correct syntax
// for (Node n : node.neighbors){ // correct syntax .. use the correct var ... 
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map <Node,Node> clones = new HashMap <>();
        Node clone = dfs (node, clones);
        return clone;       
    }

    public Node dfs (Node node, Map <Node,Node> clones) {
        if (clones.containsKey(node)) {
            return clones.get(node);
        }

        Node clone = new Node (node.val);
        clone.neighbors = new ArrayList <Node> (); // is this not needed?
        clones.put (node,clone); // important to put here ... this is like doing the visited thing in dfs ... we do that before calling nbrs , not after
        for (Node n : node.neighbors){ // correct syntax
            // clone neighbors nad add neighbors to the clone // imp
            clone.neighbors.add(dfs(n,clones));
        }
        
        return clone;
    }   

}
