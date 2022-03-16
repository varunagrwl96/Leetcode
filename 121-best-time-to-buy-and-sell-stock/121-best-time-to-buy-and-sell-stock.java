class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(prices[i]<min){
                min = prices[i];
            }
            ans = Math.max(ans,prices[i]-min);
        }
        return ans;
    }
}



// for(int j=i;j<n;j++){
//                 if(prices[j]-prices[i]<0){
//                     break;
//                 }else{
//                     ans = Math.max(ans,prices[j]-prices[i]);
//                 }
//             }