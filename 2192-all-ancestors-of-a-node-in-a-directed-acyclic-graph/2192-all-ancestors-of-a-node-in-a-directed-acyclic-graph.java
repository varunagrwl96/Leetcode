class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        //Topological Sort problem, add indegree zero to queue and add this node as parent to all its child
        HashMap<Integer,List<Integer>> hashmap = new HashMap();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            hashmap.put(i,new ArrayList());
        }
        
        for(int[] edge : edges){
            hashmap.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList();
        List<Set<Integer>> parentsets = new ArrayList<>();
        for(int i=0;i<n;i++){
            parentsets.add(new HashSet());
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int parent = queue.poll();
            List<Integer> children = hashmap.get(parent);
            for(int child : children){
                parentsets.get(child).add(parent);
                parentsets.get(child).addAll(parentsets.get(parent)); //Important, to add all parents of the parent node
                indegree[child]--;
                if(indegree[child]==0){
                    queue.add(child);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Set<Integer> set : parentsets)
            ans.add(new ArrayList<>(new TreeSet<>(set)));
        return ans;
    }
}