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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<TreeNode> hashset = new HashSet();
        for(TreeNode node : nodes){
            hashset.add(node);
        }
        return helper(root,hashset);
    }
    
    public TreeNode helper(TreeNode root, HashSet<TreeNode> hashset){
        if(root==null) return root;
        TreeNode left = helper(root.left,hashset);
        TreeNode right = helper(root.right,hashset);
        if(hashset.contains(root)){
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