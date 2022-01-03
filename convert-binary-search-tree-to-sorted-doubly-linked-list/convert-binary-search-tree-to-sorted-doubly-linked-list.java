/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first;
    Node last;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        helper(root);
        last.right=first;
        first.left=last;
        return first;
    }
    
    public void helper(Node root){
        if(root!=null){
            helper(root.left);
            if(last!=null){
                last.right=root;
                root.left=last;
                last=root;
            }else{
                last=root;
                first=root;
            }
            helper(root.right);
        }
    }
}