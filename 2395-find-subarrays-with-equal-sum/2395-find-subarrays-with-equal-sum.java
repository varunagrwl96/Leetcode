class Solution {
    public boolean findSubarrays(int[] nums) {
        int prev=0;
        int curr=0;
        for(int i=0;i<nums.length-1;i++){
            prev=nums[i]+nums[i+1];
            for(int j=i+1;j<nums.length-1;j++){
                curr = nums[j]+nums[j+1];
                if(curr==prev){
                    return true;
                }
            }
        }
        return false;
    }
}