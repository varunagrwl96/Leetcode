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
    public int diameterOfBinaryTree(TreeNode root) {
        return recursive(root).getKey();
}
    private Pair<Integer,Integer> recursive(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }
        Pair<Integer,Integer> left = recursive(root.left);
        Pair<Integer,Integer> right = recursive(root.right);
        int diameter =Math.max(Math.max(left.getKey(),right.getKey()),left.getValue()+right.getValue());
        return new Pair(diameter,Math.max(left.getValue(),right.getValue())+1);
        
    }
}