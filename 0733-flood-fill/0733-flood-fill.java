class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        
        int og = image[sr][sc];
        boolean[][] visited = new boolean[m][n];
        recursion(sr,sc,image,color,og,visited);
        return image;
    }
    
    
    public void recursion(int i, int j, int[][] image, int color, int og, boolean[][] visited){
        if(i<0||i>=image.length||j<0||j>=image[0].length||image[i][j]!=og || visited[i][j]){
            return;
        }
        visited[i][j]=true;
        image[i][j]=color;
        recursion(i+1,j,image,color,og,visited);
        recursion(i-1,j,image,color,og,visited);
        recursion(i,j+1,image,color,og,visited);
        recursion(i,j-1,image,color,og,visited);
    }
}