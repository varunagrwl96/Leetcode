class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //start compare i,i+1
        //compare i+1,i+2 jump to smallest, add cost of i
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
}

//Time O(n)
//Space O(n)
//min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])