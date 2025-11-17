// https://leetcode.com/problems/product-of-array-except-self/
// T(C) - o(n), S(C) - o(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int [0];
        }

        int len = nums.length;
        int [] L = new int [len];
        int [] R = new int [len];

        int [] ans = new int [len];
        L [0] = 1;
        R [len-1] = 1;

        for (int i=1; i < len; i++){
            L [i] = L [i-1] * nums [i-1];
        }

        for (int i = len-2; i > -1; i--) {
            R [i] = R [i+1] * nums [i+1];
        }

        for (int i=0; i < nums.length; i++){
            ans[i] = L[i] * R[i];
        }

        return ans;        
    }
}
