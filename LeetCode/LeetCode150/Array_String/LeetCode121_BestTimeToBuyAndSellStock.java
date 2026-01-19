package LeetCode150.Array_String;

public class LeetCode121_BestTimeToBuyAndSellStock {

    /**
     * Keep track of the profit so far through each day.
     * Time complexity: O(N)
     * Space complexity: O(1)
     */ 
    public int maxProfit(int[] prices) {
        int minPriceSoFar = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
            int profit = prices[i] - minPriceSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }
        
        return maxProfit;
    }
}
