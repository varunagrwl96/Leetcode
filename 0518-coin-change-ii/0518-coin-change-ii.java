class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0]=1;
        for(int coin : coins){
            for(int i=1;i<=amount;i++){
                if(i-coin<0) continue;
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
//0 1 2 3 4 5
//1 1 2 3 5 9

//2 11 2
//3 111
//4 1111 22 211