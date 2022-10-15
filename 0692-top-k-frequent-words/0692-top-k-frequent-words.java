class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashmap = new HashMap();
        for(String word : words){
            hashmap.put(word,hashmap.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<String>((i1,i2) -> (hashmap.get(i1) == hashmap.get(i2)) ? i2.compareTo(i1)  : hashmap.get(i1).compareTo(hashmap.get(i2)));
        for(String key : hashmap.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> ans = new ArrayList();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}