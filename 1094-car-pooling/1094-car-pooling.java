class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n=trips.length;
        Arrays.sort(trips, (a,b)-> a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && pq.peek()[2]<=trips[i][1]){
                capacity+=pq.peek()[0];
                pq.poll();
            }
            pq.offer(trips[i]);
            capacity-=trips[i][0];
            if(capacity<0){
                return false;
            }
        }
        return true;
    }
}