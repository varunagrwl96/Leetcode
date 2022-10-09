class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> hashmap = new HashMap();
        for(int num : nums){
            hashmap.put(num,hashmap.getOrDefault(num,0)+1);
        }
        int ans=0;
        for(int key : hashmap.keySet()){
            int find = key-k;
            if(hashmap.containsKey(find)){
                if(find==key && hashmap.get(find)<=1) continue;
                ans++;
            }
        }
        return ans;
    }
}
//O(n)
//O(n)