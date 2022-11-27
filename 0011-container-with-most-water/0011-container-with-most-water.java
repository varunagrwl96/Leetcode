class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int max=0;
        while(l<r){
            int curr = (r-l)*Math.min(height[l],height[r]);
            max=Math.max(max,curr);
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return max;
    }
}