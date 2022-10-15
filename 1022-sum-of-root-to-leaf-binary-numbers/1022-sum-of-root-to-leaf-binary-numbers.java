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
    int ans=0;
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        dfs(root,"");
        return ans;
    }
    
    public void dfs(TreeNode root,String path){
        if(root.left==null && root.right==null){
            //binary number
            path+=root.val;
            int number = Integer.parseInt(path,2);
            ans+=number;
            return;
            //add to ans
        }
        if(root.left!=null){
            dfs(root.left,path+String.valueOf(root.val));
        }
        if(root.right!=null){
            dfs(root.right,path+String.valueOf(root.val));
        }
    }
}