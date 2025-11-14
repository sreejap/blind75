// https://leetcode.com/problems/binary-search/
// note: solve by hand and implement, run through some examples
class Solution {
    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length-1;
        if (nums[0] == target) {
            return 0;
        }
        while (lo <hi) {
            int mid = lo + (hi-lo)/2;

            if (nums[mid] < target) {
                lo = mid+1; // we set lo to mid+1 because nums[mid] is less than target, so we can discard the lo value
            } else {
                hi = mid; 
            }
        }
        
        if (nums[hi] == target) {
            return hi;
        }
        return -1;
    }
}
