// https://leetcode.com/problems/combination-sum/
// Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
// Time Complexity: O(N^T/M + 1),  S(C) -  O(N^T/M + 1)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List <List<Integer>> res = new ArrayList <>();
        helper (candidates, new ArrayList <Integer>(), res, 0, target);
        return res;        
    }

    public void helper (int [] candidates, ArrayList <Integer> path, List <List<Integer>> res, int index, int target) {

        if (target ==0 ){
            res.add(new ArrayList <> (path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper (candidates, path, res, i, target - candidates[i]);
            path.remove (path.size()-1);
        }
    }
}
