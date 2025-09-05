/* You are given an array prices where prices[i] is the price of a given stock on the ith day. Find the maximum profit you can achieve. You may complete at most two transactions. Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again). 

Example 1: 
Input: prices = [3,3,5,0,0,3,1,4] 
Output: 6 
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3. Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3. 

Example 2: 
Input: prices = [1,2,3,4,5] 
Output: 4 
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4. Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again. 

Example 3: 
Input: prices = [7,6,4,3,1] 
Output: 0 
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

/* 
Logic Explanation

Step 1: Compute best profit up to each day (left[]) like the single transaction problem.

Step 2: Compute best profit from each day to end (right[]).

Step 3: For each split i, total profit = left[i] + right[i].

Step 4: Take the maximum.

This way, we handle exactly 2 transactions optimally.
 */

public class StockBuySell3 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int n = prices.length;

        // Left[i] = max profit we can get from [0..i]
        int[] left = new int[n];
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }

        // Right[i] = max profit we can get from [i..n-1]
        int[] right = new int[n];
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
        }

        // Combine left and right
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int[] prices2 = { 1, 2, 3, 4, 5 };
        int[] prices3 = { 7, 6, 4, 3, 1 };

        System.out.println(maxProfit(prices1)); // Output: 6
        System.out.println(maxProfit(prices2)); // Output: 4
        System.out.println(maxProfit(prices3)); // Output: 0
    }
}
