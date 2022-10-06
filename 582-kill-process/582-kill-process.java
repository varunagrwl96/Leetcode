class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer,List<Integer>> hashmap = new HashMap();
        for(int i=0;i<ppid.size();i++){
            if(hashmap.containsKey(ppid.get(i))){
                int parent = ppid.get(i);
                hashmap.get(parent).add(pid.get(i));
            }else{
                int parent = ppid.get(i);
                hashmap.put(parent,new ArrayList(Arrays.asList(pid.get(i))));
            }
        }
        List<Integer> ans = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        queue.add(kill);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans.add(curr);
            List<Integer> children = hashmap.get(curr);
            if(children==null) continue;
            for(int child : children){
                queue.add(child);
            }
        }
        return ans;
    }
}
// 3 1,5
// 0 3
// 5 10

//5,10