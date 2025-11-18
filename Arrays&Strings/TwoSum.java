# T(C) - O(n)
# S(C) - O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer,Integer> indexMap = new HashMap <>();

        for (int i=0; i < nums.length; i++) {
            int num = nums [i];
          
            if (indexMap.containsKey (target - num)) {
                int targetIndex = indexMap.get(target - num);
                return new int [] {i, targetIndex};
            }
            indexMap.put(nums[i],i);
        }
        return new int [] {} ;
    }
}
