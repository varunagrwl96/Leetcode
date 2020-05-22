O(rows*cols) time & O(rows*cols) space complexity
class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] tempmatrix= new int[rows][cols];
        int sum=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0 || j==0){
                    tempmatrix[i][j]=matrix[i][j];
                    sum+=tempmatrix[i][j];
                }else if(matrix[i][j]!=0){
                    tempmatrix[i][j]= Math.min(tempmatrix[i-1][j-1],Math.min(tempmatrix[i-1][j],tempmatrix[i][j-1]))+1;
                    sum+=tempmatrix[i][j];
                }else{
                    tempmatrix[i][j]=0;
                }
            }
        }
        return sum;
	}
}