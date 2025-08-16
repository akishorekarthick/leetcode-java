package dynamic_programming;

public class BestTimeToBuyAndSellStockIII {
  public static void main(String[] args) throws Exception {
    int[] A = {10, 9, 8, 7};
    System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(A));
  }

  public int maxProfit(int[] prices) {
    if (prices.length == 0 || prices.length == 1) return 0;
    int[] dp = new int[prices.length];
    int min = prices[0];
    int max = prices[prices.length - 1];
    for (int i = prices.length - 2; i >= 0; i--) {
      dp[i] = Math.max(max - prices[i], dp[i + 1]);
      max = Math.max(max, prices[i]);
    }
    max = Integer.MIN_VALUE;
    for (int i = 0; i < prices.length; i++) {
      max = Math.max(max, prices[i] - min + dp[i]);
      min = Math.min(min, prices[i]);
    }
    return max;
  }
}