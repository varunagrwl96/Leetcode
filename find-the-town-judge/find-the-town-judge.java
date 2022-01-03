class Solution {
    public int findJudge(int n, int[][] trust){
        int[] arr = new int[n+1];
        for(int i=0;i<trust.length;i++){
            int first = trust[i][0];
            int second = trust[i][1];
            arr[first]=-1;
            if(arr[second]!=-1){
                arr[second]++;
            }
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}