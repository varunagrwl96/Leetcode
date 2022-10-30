/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    String ans= "";
    int pos=0;
    public String serialize(TreeNode root) {
        recursive(root);
        System.out.println(ans.toString());
        return ans;
    }
    
    public void recursive(TreeNode root){
        if(root==null){
            ans=ans+"#,";
            return;
        }
        ans=ans+root.val+",";
        recursive(root.left);
        recursive(root.right);
    }

    // Decodes your encoded data to tree.
    // 1,2,#,#,3,4,#,#,5,#,#,
    public TreeNode deserialize(String data) {
        String[] sarr = data.split(",");
        return recursive2(sarr);
    }
    
    public TreeNode recursive2(String[] sarr){
        String curr = sarr[pos];
        if(curr.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(curr));
        pos++;
        node.left = recursive2(sarr);
        pos++;
        node.right = recursive2(sarr);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));