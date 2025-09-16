/* You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:
Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 
 */

/* 
Logic Explanation:

1. If k >= n/2, we can just do as many profitable trades as possible → same as unlimited transactions case.
2. Otherwise, we use DP:
    - dp[t][d]: max profit at day d with at most t transactions.
    - Transition:
        - Either don’t sell today: dp[t][d-1]
        - Or sell today: prices[d] + maxDiff, where maxDiff = max(dp[t-1][j] - prices[j]) for all j < d.
    - Update maxDiff as we iterate days.
Time complexity = O(k * n) 
 */

public class StockBuySell4 {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0)
            return 0;

        // If k >= n/2, it’s the same as unlimited transactions
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        // dp[t][d] = max profit up to day d with at most t transactions
        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0]; // best "buying balance" so far
            for (int d = 1; d < n; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }

        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        int[] prices1 = { 2, 4, 1 };
        int[] prices2 = { 3, 2, 6, 5, 0, 3 };

        System.out.println(maxProfit(2, prices1)); // Output: 2
        System.out.println(maxProfit(2, prices2)); // Output: 7
    }
}
