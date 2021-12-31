/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        int column=0;
        HashMap<Integer, List<Integer>> hashmap = new HashMap();
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList();
        if(root==null) return output;
        queue.add(new Pair<TreeNode,Integer>(root,column));
        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> pair = queue.poll();
            TreeNode qroot = pair.getKey();
            Integer qcol = pair.getValue();
            if(qroot!=null){
                if(hashmap.containsKey(qcol)){
                    hashmap.get(qcol).add(qroot.val);
                }else{
                    List<Integer> list = new ArrayList();
                    list.add(qroot.val);
                    hashmap.put(qcol,list);
                }
                queue.add(new Pair(qroot.left,qcol-1));
                queue.add(new Pair(qroot.right,qcol+1));
            }
        }
        List<Integer> keys = new ArrayList<Integer>(hashmap.keySet());
        Collections.sort(keys);
        for(int key : keys){
            output.add(hashmap.get(key));
        }
        return output;
    }
}