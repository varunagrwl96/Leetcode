class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor=image[sr][sc];
        int newcolor=color;
        if(newcolor==oldcolor) return image;
        color(image,sr,sc,oldcolor,newcolor);
        return image;
    }
    
    public void color(int[][] image, int sr, int sc,int oldcolor, int newcolor){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=oldcolor){
            return;
        }
        image[sr][sc]=newcolor;
        color(image,sr+1,sc,oldcolor,newcolor);
        color(image,sr-1,sc,oldcolor,newcolor);
        color(image,sr,sc+1,oldcolor,newcolor);
        color(image,sr,sc-1,oldcolor,newcolor);
    }
}

//Time -> O(n)
//Space -> O(n) recursive stack