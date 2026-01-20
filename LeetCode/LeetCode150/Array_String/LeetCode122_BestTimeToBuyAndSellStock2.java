package LeetCode150.Array_String;

public class LeetCode122_BestTimeToBuyAndSellStock2 {
    
    /**
     * Peak Valley Approach
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int maxProfit1(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
