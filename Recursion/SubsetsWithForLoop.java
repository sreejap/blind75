class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        // Add the current subset (prefix)
        result.add(new ArrayList<>(path));

        // Try every possible next element
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);              // choose nums[i]
            backtrack(nums, i + 1, path, result); // explore further
            path.remove(path.size() - 1);   // undo choice
        }
    }
}
