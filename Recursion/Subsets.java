// https://leetcode.com/problems/subsets/
// T(C) -  O(n · 2ⁿ) to generate all subsets and then copy them into the output list.
// S(C) - O(n · 2ⁿ). This is exactly the number of solutions for subsets multiplied by the number N of elements to keep for each subset. For a given number, it could be present or absent (i.e. binary choice) in a subset solution. As a result, for N numbers, we would have in total 2 N   choices (solutions). 
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length ==0){
            return new ArrayList <>();

        }
        List<List<Integer>> subsets = new ArrayList <> ();
        helper(nums, 0, new ArrayList <Integer> (), subsets);
        return subsets;        
    }

    public void helper (int [] nums, int index, ArrayList <Integer> path, List<List<Integer>> subsets){
        if (index == nums.length){
            subsets.add(new ArrayList <>(path));
            return;
        }

        path.add(nums[index]);
        helper (nums,index+1,path,subsets);

        path.remove (path.size()-1);
        helper (nums,index+1,path,subsets);
    }
}
