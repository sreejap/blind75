class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int [] dp = new int [len];       

        dp[0] = nums[0]; // this is sum at index ending 0, or i in general
        int maxSubArray = dp[0];  // Tracks the overall maximum subarray sum seen so far

        for (int i=1; i < nums.length; i++) {
            dp [i] = Math.max (dp[i-1]+nums[i], nums[i]); // we get the increasing value..
            System.out.println ("i " + i + " dp val: " + dp[i]);
            maxSubArray = Math.max (maxSubArray, dp [i]); // get max
        }

        return maxSubArray;        
    }
}
