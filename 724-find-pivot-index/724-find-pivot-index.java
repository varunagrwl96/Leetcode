class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int rsum=0;
        // int[] sum = new int[n+1];
        for(int i=0;i<n;i++){
            rsum=rsum+nums[i];
        }
        int lsum=0;
        for(int i=0;i<n;i++){
            if(lsum==(rsum-lsum-nums[i])){
                return i;
            }
            lsum=lsum+nums[i];
        }
        return -1;
    }
}

// 0 1 8 11 17 22 28