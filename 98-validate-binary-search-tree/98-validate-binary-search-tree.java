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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return validate(root, null, null);
    }
    
    public boolean validate(TreeNode root, Integer low, Integer high){
        if(root==null){
            return true;
        }        
        if((low!=null && low>=root.val) || (high!=null && high<=root.val)) return false;
        
        return validate(root.left,low,root.val) && validate(root.right,root.val,high); 
    }
}


//Time - O(n)
//Space - O(n) recursive stack