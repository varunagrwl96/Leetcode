class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer> ans = new ArrayList();
        HashMap<Integer,List<Integer>> hashmap = new HashMap();
        for(int i=0;i<n;i++){
            hashmap.put(i,new ArrayList());
        }
        
        for(List<Integer> edge :  edges){ //Make graph of incoming edges (i.e. reversed)
            hashmap.get(edge.get(1)).add(edge.get(0));
        }
        
        //Now just get nodes with no incoming edges
        for(int key : hashmap.keySet()){
            if(hashmap.get(key).size()==0){
                ans.add(key);
            }
        }
        return ans;
        
    }
}