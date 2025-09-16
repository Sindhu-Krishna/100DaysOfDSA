// buy before a rise and sell at the peak.
public class StockBuySell2 {
    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) { // check each consecutive day
            if (prices[i] > prices[i - 1]) { // If today’s price is higher than yesterday’s, add the difference to profit
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        int[] prices2 = { 1, 2, 3, 4, 5 };
        int[] prices3 = { 7, 6, 4, 3, 1 };

        System.out.println(maxProfit(prices1)); // Output: 7
        System.out.println(maxProfit(prices2)); // Output: 4
        System.out.println(maxProfit(prices3)); // Output: 0
    }
}
