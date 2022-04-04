class Solution {
    public int maxSubArray(int[] nums) {
        int t1=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            t1 = Math.max(t1+nums[i],nums[i]);
            ans = Math.max(ans,t1);
        }
        return ans;
    }
}