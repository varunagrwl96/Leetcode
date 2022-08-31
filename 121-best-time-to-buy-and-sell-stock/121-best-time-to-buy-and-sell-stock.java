class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }else{
                profit = Math.max(profit,prices[i]-min);
            }
        }
        return profit;
    }
}
//Time -> O(n)
//Space -> O(1)