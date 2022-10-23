class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList());
        generate(nums, 0, new LinkedList());
        return ans;
    }
    
    public void generate(int[] nums, int index, LinkedList<Integer> sofar){
        if(index==nums.length){
            return;
        }
        for(int i=index; i<nums.length;i++){
            sofar.add(nums[i]);
            ans.add(new ArrayList(sofar));
            generate(nums,i+1,sofar);
            sofar.removeLast();
        }
    }
}