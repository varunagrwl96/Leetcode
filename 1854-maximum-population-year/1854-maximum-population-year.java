class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] ages = new int[100];
        for(int i=0;i<logs.length;i++){
            int birth = logs[i][0];
            int death = logs[i][1];
            for(int j=birth;j<death;j++){
                ages[j-1950]+=1;
            }
        }
        int max=ages[0];
        int index=0;
        for(int i=1;i<ages.length;i++){
            if(ages[i]>max){
                max=ages[i];
                index=i;
            }
        }
        return index+1950;
    }
}