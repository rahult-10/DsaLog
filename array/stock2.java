//122. Best Time to Buy and Sell Stock II   
public int maxProfit(int[] prices) {
    return maximumProfit(prices, 0, prices.length - 1);
}

private int maximumProfit(int[] prices, int start, int end) {
    if (start >= end) {
        return 0;
    }

    int profit = 0;
    for (int i = start; i < end; i++) {
        for (int j = i + 1; j <= end; j++) {
            if (prices[j] > prices[i]) {
                int currentProfit = prices[j] - prices[i]
                        + maximumProfit(prices, start, i - 1)
                        + maximumProfit(prices, j + 1, end);

                profit = Math.max(currentProfit, profit);
            }
        }
    }
    return profit;
}

public void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};
    int result = maxProfit(prices);
    System.out.println(result);
}
