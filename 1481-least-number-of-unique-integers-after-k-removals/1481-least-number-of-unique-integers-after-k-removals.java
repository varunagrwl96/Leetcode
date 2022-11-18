class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>((a,b) -> a.getValue()-b.getValue());
        HashMap<Integer,Integer> hashmap = new HashMap();
        for(int x : arr){
            hashmap.put(x,hashmap.getOrDefault(x,0)+1);
        }
        for(int key : hashmap.keySet()){
            pq.add(new Pair(key,hashmap.get(key)));
        }
        while(k>0){
            Pair<Integer,Integer> pair = pq.peek();
            int freq = pair.getValue();
            if(k>=freq){
                k=k-freq;
                pq.poll();
            }else{
                break;
            }
            // k=k-pair.getValue();
        }
        return pq.size();
    }
}