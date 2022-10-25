class Solution {
    
    HashMap<Integer,Node> hashmap = new HashMap();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        
        for(int i=0;i<numCourses;i++){
            getNode(i);
        }
        
        for(int[] pre : prerequisites){
            int prev=pre[1];
            int next=pre[0];
            Node prevNode = getNode(prev);
            Node nextNode = getNode(next);
            prevNode.outlist.add(next);
            nextNode.indegree +=1;
        }
        
        List<Integer> zerodegree = new ArrayList();
        for(int key : hashmap.keySet()){
            if(hashmap.get(key).indegree==0){
                zerodegree.add(key);
            }
        }
        
        List<Integer> ans = new ArrayList();
        int totalremovals=0;
        while(zerodegree.size()>0){
            Integer curr = zerodegree.remove(0);
            ans.add(curr);
            for(Integer nei : hashmap.get(curr).outlist){
                Node neinode = hashmap.get(nei);
                neinode.indegree-=1;
                totalremovals++;
                if(neinode.indegree==0){
                    zerodegree.add(nei);
                }
            }
        }
        if(totalremovals==prerequisites.length){
            return ans.stream().mapToInt(i->i).toArray();
        }else{
            return new int[0];
        }
    }
    
    public Node getNode(int val){
        Node node=null;
        if(hashmap.containsKey(val)){
            return hashmap.get(val);
        }else{
            node = new Node();
            node.indegree=0;
            node.outlist=new ArrayList();
            hashmap.put(val,node);
        }
        return node;
    }
    
class Node{
    Integer indegree;
    List<Integer> outlist;
}
}
