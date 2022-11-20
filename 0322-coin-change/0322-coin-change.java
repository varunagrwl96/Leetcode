class Solution {
    // int min = Integer.MAX_VALUE;
    Integer[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new Integer[amount+1];
        return recursion(coins,amount);
    }
    
    
    public int recursion(int[] coins, int remaining){
        if(remaining==0) return 0;
        if(remaining<0) return -1;
        int min = Integer.MAX_VALUE;
        if(memo[remaining]!=null) return memo[remaining];
        for(int coin : coins){
            int count = recursion(coins,remaining-coin);
            if(count>=0){
                min=Math.min(min,count+1);
            }
        }
        memo[remaining]= min==Integer.MAX_VALUE?-1:min;
        return memo[remaining];
    }
}