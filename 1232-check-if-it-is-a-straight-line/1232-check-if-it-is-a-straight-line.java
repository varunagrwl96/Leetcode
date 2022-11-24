class Solution {
    // find slope from point 1 and point 2
    // compare the slopes of all other points wrt to the original slope
    //
    // Slope of points (x1, y1) and (x2, y2) is:
    // (y2 - y1) / (x2 - x1)
    //
    // Slope of points (x1, y1) and (x3, y3) is:
    // (y3 - y1) / (x3 - x1)
    //
    // for all three points to be on the same line, the slopes should be equal, in other words:
    // (x3 - x1)*(y2 - y1) = (y3 - y1)*(x2 - x1)
    //
    // to avoid running into divide by zero error, use multiplication to find slope
    public boolean checkStraightLine(int[][] arr) {
        if(arr == null || arr[0].length == 0) return false;
        if(arr.length == 2) return true;
       
        int[] p = arr[0];
        int[] q = arr[1];
        
        for(int i = 2; i < arr.length; i++) {
            int[] curr = arr[i];
            
            if((curr[0] - p[0]) * (q[1] - p[1]) != (curr[1] - p[1]) * (q[0] - p[0])) return false;
        }
        
        return true;
    }
}