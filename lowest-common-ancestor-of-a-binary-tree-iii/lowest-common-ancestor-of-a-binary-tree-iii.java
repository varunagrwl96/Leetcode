/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node root=p;
        HashSet<Node> hashset = new HashSet();
        while(root!=null){
            hashset.add(root);
            root=root.parent;
        }
        root=q;
        while(root!=null){
            if(hashset.contains(root)){
                return root;
            }
            root=root.parent;
        }
        return null;
    }
}