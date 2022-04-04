class Solution {
    public int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int prod=1;
        for(int i=0;i<nums.length;i++){
            prod=1;
            for(int j=i;j<nums.length;j++){
                prod=prod*nums[j];
                ans = Math.max(ans,prod);
            }
        }
        return ans;
    }
}