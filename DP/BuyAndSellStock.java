// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        // two loop would give TLE
        // we need to record the recent minprice to compute max profit, that is DP here...
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i=0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
        
    }
}
