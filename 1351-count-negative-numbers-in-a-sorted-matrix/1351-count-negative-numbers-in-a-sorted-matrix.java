class Solution {
    public int countNegatives(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int i=0;
        int j=n-1;
        while(j>=0 && i<m){
            if(grid[i][j]<0){
                j--;
                count=count+(m-i);
            }else{
                i++;
            }
        }
        return count;
    }
}
//O(m+n)
//O(1)
// 4 3 2 -1
// 3 2 1 -1
// 1 1 -1 -2
// -1 -1 -2 -3