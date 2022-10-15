class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashmap = new HashMap();
        for(String word : words){
            hashmap.put(word,hashmap.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
        (i1,i2) -> hashmap.get(i1).equals(hashmap.get(i2)) ? i2.compareTo(i1) : hashmap.get(i1).compareTo(hashmap.get(i2))
        );
        for(String word : hashmap.keySet()){
            pq.add(word);
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
        
        // List<String> ans = new ArrayList();
        // for(int i=0;i<k;i++){
        //     ans.add(pq.poll());
        // }
        // return ans;
        
        // List<String> candidates = new ArrayList<>(hashmap.keySet());
        // Collections.sort(candidates, (i1,i2) -> hashmap.get(i1).equals(hashmap.get(i2))? i1.compareTo(i2) : hashmap.get(i2).compareTo(hashmap.get(i1)));
        // return candidates.subList(0,k);
    }
}
//Time O(Nlogk)
//Space O(N)
//Time O(NlogN)
//Space O(N)