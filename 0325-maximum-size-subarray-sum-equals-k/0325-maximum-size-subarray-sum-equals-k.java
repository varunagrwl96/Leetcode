class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int maxlen=0;
        HashMap<Integer,Integer> hashmap = new HashMap();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k){
                maxlen=Math.max(maxlen,i+1);
            }
            if(hashmap.containsKey(sum-k)){
                int index = hashmap.get(sum-k);
                maxlen = Math.max(maxlen,i-index);
            }
            if(!hashmap.containsKey(sum)){
                hashmap.put(sum,i);
            }
        }
        
        return maxlen;
    }
}