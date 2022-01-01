class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hashmap = new HashMap();
        
        for(int[] arr : prerequisites){
            if(hashmap.containsKey(arr[1])){
                hashmap.get(arr[1]).add(arr[0]);
            }else{
                List<Integer> list = new ArrayList();
                list.add(arr[0]);
                hashmap.put(arr[1],list);
            }
        }
        
        boolean[] checked = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(isCyclic(i,hashmap,path,checked)){
                return false;
            }
        }
        return true;
    }
    
    public boolean isCyclic(int course, HashMap<Integer,List<Integer>> hashmap, boolean[] path, boolean[] checked){
        
        if(checked[course]){
            return false;
        }
        
        if(path[course]){
            return true;
        }
        
        if(!hashmap.containsKey(course)){
            return false;
        }
        
        path[course]=true;
        boolean ans = false;
        for(int requiredfor : hashmap.get(course)){
            ans = isCyclic(requiredfor,hashmap,path,checked);
            if(ans){
                break;
            }
        }
        path[course]=false;
        checked[course]=true;
        return ans;
    }
    
}