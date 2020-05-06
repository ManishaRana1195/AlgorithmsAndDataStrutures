package algorithms.arrays;

public class StockTrading {

  /* To try it on a new problem, start by asking yourself:

  "Suppose we could come up with the answer in one pass through the input,
  by simply updating the 'best answer so far' as we went.
  What additional values would we need to keep updated as we looked at each item in our input,
  in order to be able to update the 'best answer so far' in constant time?" */

  public static void main(String[] args) {

    int[] stockPricesPerMinute = {10, 7, 5, 8, 11, 9};
    int maxAmount = calculateMaxProfit(stockPricesPerMinute);
    System.out.println("Largest Profit that can be earned by first buying and then selling the stock:");
    System.out.println("Testcase 1: " + maxAmount);
    stockPricesPerMinute = new int[]{20, 10, 9, 8, 7, 5};
    maxAmount = calculateMaxProfit(stockPricesPerMinute);
    System.out.println("Testcase 2: " + maxAmount);
  }

  private static int calculateMaxProfit(int[] stockPricesPerMinute) {
    if (stockPricesPerMinute.length < 2) {
      throw new IllegalStateException("There should be 2 or more readings for stock");
    }

    int maxProfit = stockPricesPerMinute[1] - stockPricesPerMinute[0];
    int minValue = stockPricesPerMinute[0];

    for (int i = 1; i < stockPricesPerMinute.length; i++) {
      int currentValue = stockPricesPerMinute[i];
      int currentDiff = currentValue - minValue;
      if (minValue > currentValue) {
        minValue = currentValue;
      }
      if (currentDiff > maxProfit) {
        maxProfit = currentDiff;
      }
    }
    return maxProfit;
  }
}
