class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashmap  = new HashMap<Integer,Integer>();
        for(int num : nums){
            hashmap.put(num,hashmap.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((i,j) -> i[1]-j[1]);
        for(int key : hashmap.keySet()){
            pq.add(new int[]{key,hashmap.get(key)});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[] = new int[k];
        int i=0;
        while(pq.size()>0){
            ans[i] = pq.poll()[0];
            i++;
        }
        return ans;
    }
}