class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int maxdiff = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }else{
                maxdiff=Math.max(maxdiff,nums[i]-min);
            }
        }
        return maxdiff==0 ? -1 : maxdiff;
    }
}