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
        Stack<TreeNode> stack = new Stack();
        TreeNode pre = null;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            if(pre!=null && pre.val>=root.val){
                return false;
            }
            pre=root;
            root=root.right;
        }
        return true;
    }
    
    
//     public boolean isValidBST(TreeNode root) {
//         if(root==null) return true;
//         return validate(root, null, null);
//     }
    
//     public boolean validate(TreeNode root, Integer low, Integer high){
//         if(root==null){
//             return true;
//         }        
//         if((low!=null && low>=root.val) || (high!=null && high<=root.val)){
//             return false;
//         }
        
//         return validate(root.left,low,root.val) && validate(root.right,root.val,high); 
//     }
}


//Time - O(n)
//Space - O(n) recursive stack