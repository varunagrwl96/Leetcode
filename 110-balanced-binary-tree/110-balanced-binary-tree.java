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
    boolean bal=true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return bal;
    }
    
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int ld = dfs(root.left);
        int rd = dfs(root.right);
        if(Math.abs(ld-rd)>1){
            bal=false;
        }
        return Math.max(rd,ld)+1;
    }
}