class Solution {
    
    boolean pathExists=false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n==1) return true;
        HashMap<Integer,List<Integer>> hashmap = new HashMap();
        
        for(int i=0;i<n;i++){
            hashmap.put(i,new ArrayList());
        }
        
        //create adjacency list
        for(int[] edge : edges){
            hashmap.get(edge[0]).add(edge[1]);
            hashmap.get(edge[1]).add(edge[0]);
        }
        
        if(hashmap.get(source).contains(destination)){ //direct connection
            return true;  
        }
        boolean[] visited = new boolean[n];
        dfs(hashmap,visited,source,destination);
        return pathExists;
    }
    
    public void dfs(HashMap<Integer,List<Integer>> hashmap, boolean[] visited, int source,int destination){
        
        if(visited[source]) return;
        visited[source]=true;
        List<Integer> neighbours = hashmap.get(source);
        if(neighbours.contains(destination)){
            pathExists=true;
            return;
        }
        for(int neighbour : neighbours){
            dfs(hashmap,visited,neighbour,destination);
        }
    }
}