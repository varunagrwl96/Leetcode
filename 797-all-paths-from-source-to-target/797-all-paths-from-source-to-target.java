class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<Integer> currans = new ArrayList();
        currans.add(0);
        paths(graph,0,graph.length-1,currans);
        return ans;
    }
    
    public void paths(int[][] graph, int node, int end, List<Integer> currans){
        
        if(node==end){
            ans.add(new ArrayList<Integer>(currans));
            return;
        }
        
        for(int each : graph[node]){
            currans.add(each);
            paths(graph,each,end,currans);
            currans.remove(currans.size()-1);
        }
    }
}