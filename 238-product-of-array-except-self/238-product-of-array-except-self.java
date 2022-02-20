class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int[] ans = new int[nums.length];
        boolean hasZero = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                prod*=nums[i];
            }else{
                if(hasZero){
                    return new int[nums.length];
                }else{
                    hasZero=true;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(hasZero){
                    ans[i]=0;
                }else{
                    ans[i]=prod/nums[i];
                }
            }else{
                ans[i]=prod;
            }
        }
        return ans;
    }
}