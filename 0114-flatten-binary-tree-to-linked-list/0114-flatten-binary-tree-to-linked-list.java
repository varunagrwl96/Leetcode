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
    String flat="";
    int pos=0;
    public void flatten(TreeNode root) {        
        preorder(root);
        TreeNode roottemp = root;
        String[] flat_split = flat.split(",");
        for(int i=1;i<flat_split.length;i++){
            String x = flat_split[i];
            if(x.equals("null")){
                continue;
            }else{
                roottemp.right = new TreeNode(Integer.parseInt(x));
                roottemp.left=null;
                roottemp=roottemp.right;
            }
        }
    }
    
    public void preorder(TreeNode root){
        if(root==null){
            flat+="null,";
            return;
        }
        flat+=root.val+",";
        preorder(root.left);
        preorder(root.right);
    }
}