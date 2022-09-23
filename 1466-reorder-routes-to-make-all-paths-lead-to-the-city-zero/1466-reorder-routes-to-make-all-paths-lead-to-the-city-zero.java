class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<n;i++){
            adj.add(i,new ArrayList());
        }
        for(int[] x : connections){
            List<Integer> node = adj.get(x[0]);
            node.add(x[1]);
            List<Integer> node2 = adj.get(x[1]);
            node2.add(-x[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(adj,visited,0);
    }
    
    public int dfs(List<List<Integer>> adj, boolean[] visited, int start){
        int reorder=0;
        List<Integer> neighbors = adj.get(start);
        visited[start]=true;
        for(int x : neighbors){
            if(!visited[Math.abs(x)]){
                reorder+=dfs(adj,visited,Math.abs(x)) + (x>0?1:0);
            }
        }
        return reorder;
    }
}