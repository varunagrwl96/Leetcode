class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
        //for two subsets to have equal sum, totalsum has to even
        // if sum is odd, then two subsets cant have equal sum
        if(sum%2!=0) return false; 
        int targetsum = sum/2;
        dp = new Boolean[nums.length + 1][targetsum + 1];
        
        return recursion(nums,0,targetsum);
    }
    
    
    public boolean recursion(int[] nums, int index, int targetsum){
        if(index==nums.length){
            return false;
        }
        if(targetsum<0) return false;
        if(targetsum==0){
            return true;
        }
        if(dp[index][targetsum]!=null) return dp[index][targetsum];
        
        boolean result = recursion(nums,index+1,targetsum-nums[index]) || recursion(nums,index+1,targetsum);
        
        dp[index][targetsum]=result;
        return result;
    }
}