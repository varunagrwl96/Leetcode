class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        
        HashMap<Integer,GNode> hashmap = new HashMap();
        
        for(int i=0;i<numCourses;i++){
            createGNode(i,hashmap);
        }
        
        for(int[] pre : prerequisites){
            GNode next = createGNode(pre[0],hashmap);
            GNode prev = createGNode(pre[1],hashmap);
            prev.outdegree.add(pre[0]);
            next.indegree+=1;
        }
        
        List<Integer> zerodegree= new ArrayList();
        
        for(Map.Entry<Integer,GNode> entry : hashmap.entrySet()){
            if(entry.getValue().indegree==0){
                zerodegree.add(entry.getKey());
            }
        }
        
        int totalremovals=0;
        int[] ans = new int[numCourses];
        int index=0;
        
        while(zerodegree.size()>0){
            Integer val = zerodegree.remove(0);
            ans[index++]=val;
            GNode node = hashmap.get(val);
            for(Integer outnodeCourse : node.outdegree){
                GNode outnode = hashmap.get(outnodeCourse);
                outnode.indegree--;
                totalremovals++;
                if(outnode.indegree==0){
                    zerodegree.add(outnodeCourse);
                }
            }
        }
        if(index!=numCourses){ //comparing index with numcourses or totalremovals with prereqs length, do not compare ans length with numcourses coz it is initialized with zero and size will be something even if there were no nodes with zero indegree
            return new int[0];
        }else{
            return ans;
        }
    }
    
    public GNode createGNode(int course, HashMap<Integer,GNode> hashmap){
        GNode node=null;
        if(hashmap.containsKey(course)){
            node = hashmap.get(course);
        }else{
            node = new GNode();
            node.outdegree=new ArrayList<Integer>();
            node.indegree=0;
            hashmap.put(course,node);
        }
        return node;
    }
}

class GNode{
    Integer indegree;
    List<Integer> outdegree;
}