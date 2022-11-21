// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount+1];
//         Arrays.fill(dp,amount+1); //Important, no Integer.MAX_Value coz +1 in math.min will make it -ve and will be taken as minimum
//         dp[0]=0;
//         for(int i=1;i<=amount;i++){
//             for(int coin : coins){
//                 if(i-coin<0) continue;
//                 dp[i]=Math.min(dp[i-coin]+1,dp[i]);
//             }
//         }
//         return dp[amount]==amount+1? -1 : dp[amount];
//     }
// }

class Solution {
    Integer[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new Integer[amount+1];
        return recursion(coins,amount);
    }
    
    public int recursion(int[] coins, int amount){
        if(amount==0) return 0;
        if(amount<0) return -1;
        if(memo[amount]!=null) return memo[amount];
        int ans=Integer.MAX_VALUE;
        for(int coin : coins){
            int val = recursion(coins,amount-coin);
            if(val>=0){
                ans = Math.min(ans,val+1);
            }
        }
        memo[amount] = ans==Integer.MAX_VALUE?-1:ans;
        return memo[amount];
    }
}