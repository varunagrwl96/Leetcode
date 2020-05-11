Faster & cleaner solution 
Time complexity: O(m*n), space complexity: O(1). m is number of rows, n is number of columns.
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
        {
            return;
        }
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
--------------------------------------------------------------
O(m*n) time complexity O(m*n) space complexity
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int value = image[sr][sc];
        boolean[][] visited = new boolean[rows][cols];
        List<Pair<Integer,Integer>> directions = new ArrayList();
        directions.add(new Pair(1,0));
        directions.add(new Pair(0,1));
        directions.add(new Pair(-1,0));
        directions.add(new Pair(0,-1));
        Queue<Pair<Integer,Integer>> queue = new LinkedList();
        image[sr][sc]=newColor;
        queue.add(new Pair(sr,sc));
        while(!queue.isEmpty()){
            Pair<Integer,Integer> pair = queue.remove();
            visited[pair.getKey()][pair.getValue()]=true;
            for(Pair<Integer,Integer> p : directions){
                int pairrow = pair.getKey() + p.getKey();
                int paircol = pair.getValue() + p.getValue();
                if(checkBoundary(pairrow,paircol,rows,cols) && !visited[pairrow][paircol] && image[pairrow][paircol]==value){
                    image[pairrow][paircol]=newColor;
                    queue.add(new Pair(pairrow,paircol));
                    visited[pairrow][paircol]=true;
                }
            }
        }
        return image;
    }
    
    public boolean checkBoundary(int sr, int sc,int rows, int cols){
         return sr>=0 && sr <rows && sc>=0 && sc<cols;
    }
}