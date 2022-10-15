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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root;
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left,root2.left);
        root.right = mergeTrees(root1.right,root2.right);
        return root;
    }
    
    public TreeNode recursion(TreeNode root1, TreeNode root2){
        TreeNode root=null;
        if(root1!=null && root2!=null){
            root = new TreeNode(root1.val + root2.val);
        }
        if(root1!=null && root1.left!=null && root2!=null && root2.left!=null){
            root.left = mergeTrees(root1.left,root2.left);
        }else if(root1.left!=null){
            root.left = root1.left;
        }else{
            root.left = root2.left;
        }
        if(root1!=null && root1.right!=null && root2!=null && root2.right!=null){
            root.right = mergeTrees(root1.right,root2.right);
        }else if(root1.right!=null){
            root.right = root1.right;
        }else{
            root.right = root2.right;
        }
        return root;
    }
}

