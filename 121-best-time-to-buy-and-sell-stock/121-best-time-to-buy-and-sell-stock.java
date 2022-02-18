class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int curr = prices[0];
        int ans=0;
        for(int i=1;i<prices.length;i++){
            if(curr>prices[i]){
                curr=prices[i];
            }else{
                ans = Math.max(ans,prices[i]-curr);
            }
        }
        return ans;
    }
}