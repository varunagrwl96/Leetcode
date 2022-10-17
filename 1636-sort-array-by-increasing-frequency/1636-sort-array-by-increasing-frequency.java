class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> hashmap = new HashMap();
        for(Integer num: nums){
            hashmap.put(num, hashmap.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i1,i2) -> hashmap.get(i1)==hashmap.get(i2)? i2.compareTo(i1) : hashmap.get(i1).compareTo(hashmap.get(i2)));
        
        for(int key : hashmap.keySet()){
            pq.add(key);
        }
        
        
        int[] ans = new int[nums.length];
        int i=0;
        while(!pq.isEmpty()){
            int key=pq.poll();
            int freq = hashmap.get(key);
            while(freq>0){
                ans[i]=key;
                i++;
                freq--;
            }
        }
        return ans;
    }
}

// 1 2
// 2 3
// 3 1