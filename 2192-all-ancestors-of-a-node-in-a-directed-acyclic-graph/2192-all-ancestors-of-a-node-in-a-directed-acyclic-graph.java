// class Solution {
//     public List<List<Integer>> getAncestors(int n, int[][] edges) {
//         HashMap<Integer,List<Integer>> hashmap = new HashMap();
        
//         for(int i=0;i<n;i++){
//             hashmap.put(i,new ArrayList());
//         }
        
//         for(int[] edge : edges){
//             int src=edge[0];
//             int dest=edge[1];
//             hashmap.get(dest).add(src);
//         }
        
//         List<List<Integer>> ans = new ArrayList();
//         for(int i=0;i<n;i++){
//             HashSet<Integer> currans = new HashSet();
//             bfs(i,currans,hashmap);
//             List<Integer> anslist =new ArrayList<Integer>(currans); 
//             Collections.sort(anslist);
//             ans.add(anslist);
//         }
//         return ans;
//     }
    
//     public void bfs(int node, HashSet<Integer> currans, HashMap<Integer,List<Integer>> hashmap){
//         List<Integer> parents = hashmap.get(node);
//         if(parents.size()==0) return ;
//         for(int parent : parents){
//             currans.add(parent);
//             bfs(parent,currans,hashmap);
//         }
//     }
// }
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] parents = new ArrayList[n];
        TreeSet<Integer>[] ancestors = new TreeSet[n];
        for (int i = 0; i < n; ++ i) {
            parents[i] = new ArrayList<>();
        }
        
        for (int[] edge: edges) {
            parents[edge[1]].add(edge[0]);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; ++ i) {
            if (ancestors[i] == null) {
                dfs(i, parents, ancestors);
            }
            
            result.add(new ArrayList<>(ancestors[i]));
        }
        
        return result;
    }
    
    public void dfs(int node, List<Integer>[] parents, TreeSet<Integer>[] ancestors) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int parent: parents[node]) {
            set.add(parent);
            if (ancestors[parent] == null) {
                dfs(parent, parents, ancestors);
            }
            set.addAll(ancestors[parent]);
        }
        
        ancestors[node] = set;
    }
}