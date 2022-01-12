class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        helper(nums,0,new ArrayList<Integer>(),ans);
        return ans;
    }
    
    public void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<Integer>(list));
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            helper(nums,i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
}