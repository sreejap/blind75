public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Integer[] chars = new Integer[128]; 
      // Stores the last seen index of each ASCII character.
      // chars[r] gives you the last index where character r appeared.

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);

            Integer index = chars[r];
            // If the character has been seen inside the current window, jump left directly after its last occurrence.
            // This skips the while-loop you had in the HashSet version.
            if (index != null && index >= left && index < right) {
                left = index + 1;
              
            }

            res = Math.max(res, right - left + 1);

            chars[r] = right;
            right++;
        }

        return res;
    }
}
