class Solution {
    public int[] runningSum(int[] nums) {
        // int sum=0;
        for(int i=1;i<nums.length;i++){
            // sum = sum+nums[i];
            nums[i]=nums[i-1]+nums[i];
        }
        return nums;
    }
}