class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i-1]==nums[i]){
                continue;
            }
            twoSum(nums,i,ans);
        }
        return ans;
    }
    
    public void twoSum(int[] nums, int i, List<List<Integer>> ans){
        int start=i+1;
        int end = nums.length-1;
        while(start<end){
            if(nums[i]+nums[start]+nums[end]==0){
                ans.add(Arrays.asList(nums[i],nums[start],nums[end]));
                start++;
                end--;
                while(start<end && nums[start]==nums[start-1]){ //dont consider dups
                    start++;
                }
            }else if(nums[i]+nums[start]+nums[end]>0){
                end--;
            }else if(nums[i]+nums[start]+nums[end]<0){
                start++;
            }
        }
    }
}