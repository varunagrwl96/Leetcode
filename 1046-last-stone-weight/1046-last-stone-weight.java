class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int x : stones){
            pq.add(x);
        }
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            if(first!=second){
                pq.add(Math.abs(first-second));
            }
        }
        if(pq.size()>0) return pq.poll();
        return 0;
    }
}