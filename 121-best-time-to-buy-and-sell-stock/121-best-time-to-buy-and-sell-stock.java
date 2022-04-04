class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int min=prices[0];
        int curr=prices[0];
        for(int i=0;i<prices.length;i++){
            curr=prices[i];
            if(curr<min){
                min=curr;
            }
            max = Math.max(max,curr-min);
        }
        return max;
    }
}