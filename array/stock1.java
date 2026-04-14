public int stock(int[] prices) {
    int buyPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for(int i = 0; i< prices.length; i++){
        if(buyPrice < prices[i]){
            int profit = prices[i] - buyPrice;
            maxProfit = Math.max(profit, maxProfit);
        }
        else {
            buyPrice = prices[i];
        }
    }
    return maxProfit;

}
public void main(String[] args) {
    int[] prices = {7,6,4,3,1};
    int result  = stock(prices);
    System.out.println(result);
}