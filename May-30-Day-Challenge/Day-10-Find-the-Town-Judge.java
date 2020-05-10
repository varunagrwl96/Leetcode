O(N) space O(N) time complexity
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
}
---------------------------------------------
class Solution {
    public int findJudge(int N, int[][] trust) {
        Graph graph = new Graph(N);
        int[] ans = new int[N];
        for(int i=0;i<trust.length;i++){
            graph.addEdge(trust[i][0]-1,trust[i][1]-1);
            ++ans[trust[i][1]-1];
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]==N-1 && !graph.hasneighbors(i)){
                return i+1;
            }
        }
        return -1;
    }
}

class Graph 
{ 
    private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Lists 
  
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
    }
     boolean hasneighbors(int s) { 
        Iterator<Integer> i = adj[s].listIterator(); 
        return i.hasNext();
    } 
} 