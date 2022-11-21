class Solution {
    public int convertTime(String current, String correct) {
        String[] curr = current.split(":");
        int currmins = Integer.parseInt(curr[0])*60 + Integer.parseInt(curr[1]);
        String[] corr = correct.split(":");
        int corrmins = Integer.parseInt(corr[0])*60 + Integer.parseInt(corr[1]);
        
        int[] dp = new int[corrmins+1];
        int[] choices = new int[]{1,5,15,60};
        Arrays.fill(dp,corrmins+1);
        dp[currmins]=0;
        for(int i=currmins;i<=corrmins;i++){
            for(int choice : choices){
                if(i-choice<currmins) continue;
                dp[i]=Math.min(dp[i-choice]+1,dp[i]);
            }
        }
        return dp[corrmins];
    }
}