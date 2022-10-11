class Solution {
    
    HashMap<String,List<String>> adjList = new HashMap();
    HashMap<String,boolean[]> visitMap = new HashMap();
    int flights=0;
    List<String> result;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for(int i=0;i<tickets.size();i++){
            String src = tickets.get(i).get(0);
            String dest = tickets.get(i).get(1);
            if(adjList.containsKey(src)){
                adjList.get(src).add(dest);
            }else{
                List<String> list = new LinkedList();
                list.add(dest);
                adjList.put(src,list);
            }
        }
        
        for(String key : adjList.keySet()){
            Collections.sort(adjList.get(key));
            visitMap.put(key,new boolean[adjList.get(key).size()]);
        }
        LinkedList<String> ans = new LinkedList();
        ans.add("JFK");
        this.flights=tickets.size();
        backtracking("JFK",ans);
        // for(String key : visitMap.keySet()){
        //     System.out.println(key+" "+visitMap.get(key));
        // }
        
        //dfs or bfs
        return this.result;
    }
    
    public boolean backtracking(String src, LinkedList<String> ans){
        
        if(ans.size()==this.flights+1){
            this.result = new ArrayList(ans);
            return true;
        }
        List<String> neighbours = this.adjList.get(src);
        if(neighbours==null || neighbours.size()==0){
            return false;
        }
        
        boolean[] visitarr = this.visitMap.get(src);
        for(int i=0;i<neighbours.size();i++){
            if(!visitarr[i]){
                visitarr[i]=true;
                ans.add(neighbours.get(i));
                boolean ret = backtracking(neighbours.get(i),ans);
                ans.pollLast();
                visitarr[i]=false;
                
                if(ret){
                    return true;
                }
            }
        }
        return false;   
        
    }
}