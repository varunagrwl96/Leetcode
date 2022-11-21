class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> daysset = new HashSet();
        for(int day : days){
            daysset.add(day);
        }
        
        int[] dp = new int[366];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=365;i++){
            if(!daysset.contains(i)){
                dp[i]=dp[i-1];
            }else{
                dp[i]=Math.min(dp[i],Math.min(dp[Math.max(i-1,0)]+costs[0], Math.min(dp[Math.max(i-7,0)]+costs[1], dp[Math.max(i-30,0)] + costs[2])));
            }
        }
        return dp[365];
    }
}