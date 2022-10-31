class Solution {
    public int numOfPairs(String[] nums, String target) {
        int count=0;
        int n = target.length();
        HashMap<String,Integer> hashmap = new HashMap();
        for(int i=0;i<nums.length;i++){
            hashmap.put(nums[i],hashmap.getOrDefault(nums[i],0)+1);
        }
        for(int i=1;i<n;i++){
            String pre = target.substring(0,i);
            String post = target.substring(i,n);
            if(hashmap.containsKey(pre) && hashmap.containsKey(post)){
                if(!pre.equals(post)){
                    count = count + (hashmap.get(pre)*hashmap.get(post));
                }else{
                    count = count + (hashmap.get(pre)*(hashmap.get(pre)-1));
                }
            }
        }
        return count;
    }
}