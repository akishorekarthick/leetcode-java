package dynamic_programming;

public class BestTimeToBuyAndSellStocksWithFee {
  public static void main(String[] args) throws Exception {
    int[] A = {1, 3, 2, 8, 4, 9};
    System.out.println(new BestTimeToBuyAndSellStocksWithFee().maxProfit(A, 2));
  }

  public int maxProfit(int[] prices, int fee) {
    int cash = 0, stock = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      cash = Math.max(cash, prices[i] + stock - fee);
      stock = Math.max(stock, cash - prices[i]);
    }
    return cash;
  }
}