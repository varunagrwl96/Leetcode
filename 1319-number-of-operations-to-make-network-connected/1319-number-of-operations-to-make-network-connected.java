class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; // To connect all nodes need at least n-1 edges
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        int components = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            components += dfs(i, graph, visited);
        } 
        return components - 1; // Need (components-1) cables to connect components together
    }
    int dfs(int node, List<Integer>[] graph, boolean[] visited) {
        if (visited[node]) return 0;
        visited[node] = true;
        for (int nei : graph[node]){
          dfs(nei, graph, visited);  
        } 
        return 1;
    }
}