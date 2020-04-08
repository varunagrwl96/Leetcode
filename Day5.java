class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int profit=0;
	    for(int i=0;i<size-1;i++){
            if(prices[i]<prices[i+1]){
                profit+=prices[i+1]-prices[i];
            }
        }
        return profit;
    }
}