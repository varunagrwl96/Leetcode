class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        // HashMap<Integer,List<Integer>> hashmap = new HashMap();
        // for(int i=0;i<graph.length;i++){
        //     hashmap.put(i,new ArrayList())
        // }
        // LinkedList<Integer> currans = new LinkedList();
        List<Integer> currans = new ArrayList();
        // currans.addLast(0);
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
            // currans.addLast(each);
            currans.add(each);
            paths(graph,each,end,currans);
            // currans.removeLast();
            currans.remove(currans.size()-1);
        }
    }
}