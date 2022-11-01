/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, List<TreeNode>> hashmap = new HashMap();
        HashSet<TreeNode> visitedSet = new HashSet();
        buildMap(hashmap, root, null);
        Queue<TreeNode> queue = new LinkedList();
        queue.add(target);
        visitedSet.add(target);
        while(!queue.isEmpty()){
            if(k==0){
                break;
            }
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                for(TreeNode nei : hashmap.get(curr)){
                    if(visitedSet.contains(nei)) continue;
                    queue.add(nei);
                    visitedSet.add(nei);
                }
            }
            k--;
        }
        List<Integer> ans = new ArrayList();
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }
    
    
    public void buildMap(HashMap<TreeNode, List<TreeNode>> hashmap, TreeNode root, TreeNode parent){
        if(root==null) return;
        if(!hashmap.containsKey(root)){
            hashmap.put(root,new 
                        ArrayList<TreeNode>());
        }
        if(root.left!=null){
            hashmap.get(root).add(root.left);
        }
        if(root.right!=null){
            hashmap.get(root).add(root.right);
        }
        if(parent!=null){
            hashmap.get(root).add(parent);
        }
        buildMap(hashmap, root.left, root);
        buildMap(hashmap, root.right, root);
        
    }
}