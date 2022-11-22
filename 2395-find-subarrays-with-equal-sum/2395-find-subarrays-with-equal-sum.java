class Solution {
    public boolean findSubarrays(int[] nums) {
        
        HashSet<Integer> hashset = new HashSet();
        for(int i=0;i<nums.length-1;i++){
            if(hashset.contains(nums[i]+nums[i+1])){
                return true;
            }else{
                hashset.add(nums[i]+nums[i+1]);
            }
        }
        return false;
    }
}