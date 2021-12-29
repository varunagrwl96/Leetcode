class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashmap=new HashMap();
        for(int i=0;i<nums.length;i++){
            if(hashmap.containsKey(nums[i])){
                hashmap.put(nums[i],hashmap.get(nums[i])+1);
            }else{
                hashmap.put(nums[i],1);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(Integer key : hashmap.keySet()){
            if(pq.size()==k){
                pq.add(new int[]{key,hashmap.get(key)});
                pq.poll();
            }else{
                pq.add(new int[]{key,hashmap.get(key)});
            }
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll()[0];
        }
        return ans;
    }
}