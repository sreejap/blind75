// https://leetcode.com/problems/combinations/
// T(c) o(nCk) , S(C) - o(k)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n ==0) {
            return new ArrayList <>();
        }

        List <List<Integer>> res = new ArrayList <>();
        helper (n,1,new ArrayList <Integer>(),res,k);
        return res;        
    }

    public void helper (int n, int start, ArrayList <Integer> path, List <List<Integer>> res, int k) {
        if (path.size()==k){
            res.add( new ArrayList <Integer>(path));
            return;
        }

        for (int i = start; i <= n; i++){
            path.add(i);
            helper (n,i+1, path, res,k);
            path.remove(path.size()-1);             
        }
    }
}
