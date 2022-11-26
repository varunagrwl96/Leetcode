class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m+1][n+1];
        for(int[] p : prices){
            dp[p[0]][p[1]]=p[2];
        }
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                for(int x=1;x<=i/2;x++){
                    dp[i][j]=Math.max(dp[i][j],dp[x][j]+dp[i-x][j]);
                }
                for(int x=1;x<=j/2;x++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][x]+dp[i][j-x]);
                }
            }
        }
        return dp[m][n];
    }
}