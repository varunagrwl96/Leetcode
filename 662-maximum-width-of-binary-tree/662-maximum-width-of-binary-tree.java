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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList();
        queue.add(new Pair(root,0));
        int width=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            Pair<TreeNode,Integer> head = queue.peek();
            Pair<TreeNode,Integer> currpair = null;
            for(int i=0;i<size;i++){
                currpair = queue.poll();
                TreeNode curr = currpair.getKey();
                int currindex = currpair.getValue();
                if(curr.left!=null){
                    queue.add(new Pair(curr.left,currindex*2));
                }
                if(curr.right!=null){
                    queue.add(new Pair(curr.right,currindex*2 +1));
                }
            }
            width = Math.max(width,currpair.getValue() - head.getValue() + 1);
        }
        return width;
    }
}