class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int rooms=0;
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && pq.peek()[1]<=intervals[i][0]){
                pq.poll();
            }
            pq.offer(intervals[i]);
            rooms=Math.max(rooms,pq.size());
        }
        return rooms;
    }
}