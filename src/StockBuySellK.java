/* Stock Buy Sell IV optimized:

Instead of storing a full dp[k+1][n] table, we just keep track of current transaction profits and previous transaction profits using 1D arrays.

Improvements:
- Space reduced from O(k·n) → O(n).
- Still O(k·n) time.
- Cleaner memory usage (important when n is big).
 */

public class StockBuySellK {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0)
            return 0;

        // If k >= n/2, treat as unlimited transactions
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[] prev = new int[n];
        int[] curr = new int[n];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int d = 1; d < n; d++) {
                curr[d] = Math.max(curr[d - 1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, prev[d] - prices[d]);
            }
            // Swap references instead of copying
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n - 1];
    }

    public static void main(String[] args) {
        int[] prices1 = { 2, 4, 1 };
        int[] prices2 = { 3, 2, 6, 5, 0, 3 };

        System.out.println(maxProfit(2, prices1)); // Output: 2
        System.out.println(maxProfit(2, prices2)); // Output: 7
    }
}
