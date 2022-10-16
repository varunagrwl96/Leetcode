class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(i==0|| nums[i]!=nums[i-1]){
                twoSum(i,nums,ans);
            }
        }
        return ans;
    }
    
    public void twoSum(int i, int[] nums, List<List<Integer>> ans){
        int curr = nums[i];
        int start=i+1;
        int end = nums.length-1;
        while(start<end){
            if(curr + nums[start]+nums[end]==0){
                ans.add(Arrays.asList(curr,nums[start],nums[end]));
                start++;
                end--;
                while(start<end && nums[start]==nums[start-1]){
                    start++;
                }
            }else if(curr + nums[start]+nums[end]<0){
                start++;
            }else{
                end--;
            }
        }
    }
}

// -4 -1 -1 0 1 2