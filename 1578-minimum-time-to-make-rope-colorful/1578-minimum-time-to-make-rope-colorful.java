class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=neededTime.length;
        int left=0;
        int right=0;
        int max=0;
        int sum=0;
        int cost=0;
        while(right<n){
            char lchar = colors.charAt(left);
            char rchar = colors.charAt(right);
            if(lchar==rchar){
                sum+=neededTime[right];
                max=Math.max(max,neededTime[right]);
                right++;
            }else{
                cost+=sum-max;
                sum=0;
                max=0;
                left=right;
            }
        }
        cost+=sum-max;
        return cost;
    }
}