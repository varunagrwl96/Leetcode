class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Node> hashmap = new HashMap();
        for(int i=0;i<numCourses;i++){
            hashmap.put(i, new Node());
        }
        for(int[] pre : prerequisites){
            int dest= pre[0];
            int src = pre[1];
            hashmap.get(src).outdegree.add(dest);
            hashmap.get(dest).indegree++;
        }
        
        Queue<Node> queue = new LinkedList();
        for(int key : hashmap.keySet()){
            if(hashmap.get(key).indegree==0){
                queue.add(hashmap.get(key));
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            count++;
            List<Integer> out = curr.outdegree;
            for(int x : out){
                // out.remove(x);
                Node nei = hashmap.get(x);
                nei.indegree--;
                if(nei.indegree==0){
                    queue.add(nei);
                }
            }
        }
        if(count==numCourses){
            return true;
        }else{
            return false;
        }
    }
}


class Node{
    List<Integer> outdegree;
    Integer indegree;
    
    public Node(){
        outdegree = new ArrayList();
        indegree=0;
    }
}