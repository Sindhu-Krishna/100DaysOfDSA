public class StockBuySell {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // update min price
            if (price < minPrice) {
                minPrice = price;
            }
            // update profit if current price gives better profit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int profit = maxProfit(prices);
        System.out.println("Max profit (1 transaction): " + profit);
    }
}
