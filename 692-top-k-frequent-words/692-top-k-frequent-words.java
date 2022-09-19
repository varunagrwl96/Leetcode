class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // PriorityQueue<Pair<String,Integer>> pq = new PriorityQueue();
        HashMap<String, Integer> hashmap = new HashMap();
        for(String word : words){
            hashmap.put(word,hashmap.getOrDefault(word,0)+1);
            
        }
        List<String> candidates = new ArrayList<>(hashmap.keySet());
        // Collections.reverseOrder(candidates);
        Collections.sort(candidates, (i1,i2) -> hashmap.get(i1).equals(hashmap.get(i2))? i1.compareTo(i2) : hashmap.get(i2).compareTo(hashmap.get(i1)));
        // for(String x : candidates){
        //     System.out.print(x);
        // }
        return candidates.subList(0,k);
        // return null;
    }
}