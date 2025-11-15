class Solution {
    public int maxSubArray(int[] nums) {       
        
        int sum = nums[0];
        int maxSubArray = sum;
        for (int i=1; i < nums.length; i++){
            sum = Math.max (sum+nums[i],nums[i]); // we decide if we want to keep it or discard it
            maxSubArray = Math.max (sum,maxSubArray);
        }

        return maxSubArray;
    }
}
