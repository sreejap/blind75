// https://leetcode.com/problems/contains-duplicate/
// t(C) - o(n)
// s(C) - o(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // have a set
        Set <Integer> els = new HashSet <>();
        for (int n : nums) {
            if (els.contains(n)) {
                return true;
            } else {
                els.add(n);
            }
        }
        return false;
    }
}
