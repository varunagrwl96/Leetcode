class Solution {
    public int findCenter(int[][] edges) {
        int one=0;
        int two=0;
        for(int i=0;i<edges.length;i++){
            if(one==edges[i][0] || one==edges[i][1]){
                return one;
            }else if(two==edges[i][0] || two==edges[i][1]){
                return two;
            }
            one=edges[i][0];
            two=edges[i][1];
        }
        return 0;
    }
}