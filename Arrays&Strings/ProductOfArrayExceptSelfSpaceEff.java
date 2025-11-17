// S(c) - o(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int []ans = new int [len];
        ans[0] = 1; // this is prefix

        for (int i=1; i < nums.length; i++){
            ans[i] = ans [i-1] * nums [i-1];
        }

        int R = 1; //this is suffix

        for (int i = len-1; i >-1; i--){
            ans[i] = ans [i] * R; // we are multiplying with suffix 
            R *= nums[i]; // then updating suffix ..
        }

        return ans;
    }
}
