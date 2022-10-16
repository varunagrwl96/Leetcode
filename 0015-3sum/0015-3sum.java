class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums); //Important
        for(int i=0;i<n;i++){
            if(i==0 || nums[i-1]!=nums[i]){ //duplicates
                twosum(i,nums,ans);
            }
        }
        return ans;
    }
    
    public void twosum(int index, int[] nums, List<List<Integer>> ans){
        int start=index+1;
        int end = nums.length-1;
        int sum = 0-nums[index];
        while(start<end){
            if(nums[start] + nums[end]==sum){
                ans.add(Arrays.asList(nums[start],nums[end],nums[index]));
                start++;
                end--;
                while(start<end && nums[start]==nums[start-1]){ //dups
                    start++;
                }
            }
            else if(nums[start] + nums[end]>sum){
                end--;
            }
            else{
                start++;
            }
        }
    }
}
//O(n^2)
//O(1)