// https://leetcode.com/problems/permutations/
// T(C) - o(n*n!) - Given a set of length n, the number of permutations is n! (n factorial). There are n options for the first number, n−1 for the second, and so on. For each of the n! permutations, we need O(n) work to copy curr into the answer. This gives us O(n⋅n!) work. You have to output n! permutations, each of length n → copying costs O(n·n!)
// S(C) - o(n)

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList <>();
        }

        List <List <Integer>> res = new ArrayList <>();
        helper (nums, new ArrayList <Integer>(), res);
        return res;        
    }

    public void helper (int []nums, ArrayList <Integer> path, List <List <Integer>> res){
        if (path.size() == nums.length){
            // this is permuations problem and we need all elements
            res.add(new ArrayList<>(path));
            return;
        }

        for (int n: nums) {
            if (!path.contains(n)){
                path.add(n);
                helper (nums, path, res);
                path.remove (path.size()-1);
            }
        }
    }
}
