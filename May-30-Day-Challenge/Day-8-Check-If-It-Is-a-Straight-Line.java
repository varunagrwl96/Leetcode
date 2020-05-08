class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        float slope=0;
        for(int i=1;i<coordinates.length;i++){
            float slope2 =(float)(coordinates[i][1]-coordinates[i-1][1])/(float)(coordinates[i][0]-coordinates[i-1][0]);
            if(slope==0){
                slope=slope2;
            }else if(slope!=slope2){
                return false;
            }else{
                continue;
            }
        }
        return true;
    }
}