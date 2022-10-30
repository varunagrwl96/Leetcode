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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

		// left subtree
        flatten(root.left);
		// right subtree
        flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        // find the farest right node.
        while (root.right != null) {
            root = root.right;
        }

        root.right = temp;
    }
}