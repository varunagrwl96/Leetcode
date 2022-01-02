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
    boolean pfound=false;
    boolean qfound=false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = helper(root,p,q);
        if(pfound && qfound){
            return ans;
        }else{
            return null;
        }
    }
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        TreeNode left = helper(root.left,p,q);
        TreeNode right = helper(root.right,p,q);
        if(root==p){
            pfound=true;
            return root;
        }
        if(root==q){
            qfound=true;
            return root;
        }
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }else{
            return right;
        }
    }
}