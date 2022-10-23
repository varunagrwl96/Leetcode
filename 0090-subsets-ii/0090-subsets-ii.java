class Solution {
    
    List<List<Integer>> ans = new ArrayList();
    // HashSet<List<Integer>> ans = new HashSet();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans.add(new ArrayList());
        generate(nums,0, new LinkedList());
        return new ArrayList(ans);
    }
    
    public void generate(int[] nums, int index, LinkedList<Integer> sofar){
        if(index==nums.length){
            return;
        }
        
        for(int i=index; i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]){
                continue;
            }
            sofar.add(nums[i]);
            ans.add(new ArrayList(sofar));
            generate(nums,i+1,sofar);
            sofar.removeLast();
        }
    }
}