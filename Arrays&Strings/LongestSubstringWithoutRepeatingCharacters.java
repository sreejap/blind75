// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// T(C) - o(n), S(C) - o (min (m,n)) The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length () == 0) {
            return 0;
        }

        Set <Character> chars = new HashSet <>();
        int maxLen = 0;
        int left = 0;
        for (int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char leftChar = s.charAt (left);
            while (chars.contains(ch)) {
                
                chars.remove(leftChar);
                left++;
                leftChar = s.charAt (left);
                
            }
            chars.add(ch); // for set the method is add
            int len = i - left +1;
            maxLen = Math.max (len, maxLen);
        }
        return maxLen;
    }
}
