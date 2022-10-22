class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hashmap = new HashMap();
        int presum=0;
        int count=0;
        hashmap.put(0,1);
        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            if(hashmap.containsKey(presum-k)){
                int value = hashmap.get(presum-k);
                count+=value;
            }
            hashmap.put(presum,hashmap.getOrDefault(presum,0)+1);
        }
        return count;
    }
}