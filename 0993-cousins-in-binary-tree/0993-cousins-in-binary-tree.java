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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int xdepth=-1;
        int ydepth=-1;
        int depth=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr.val==x){
                    xdepth=depth;
                }
                if(curr.val==y){
                    ydepth=depth;
                }
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y) return false;
                    if(curr.left.val==y && curr.right.val==x) return false;
                }
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            depth++;
        }
        return xdepth==ydepth;
    }
}
//O(N)
//O(N)