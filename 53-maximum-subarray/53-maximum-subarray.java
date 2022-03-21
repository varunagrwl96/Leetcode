class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum=0;
        int ans=nums[0];
        for(int i=0;i<n;i++){            
            sum = Math.max(sum+nums[i],nums[i]);
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}

// -2 -1 -4 0 -1 1 2 -3 1

// 5 9 8 15 23