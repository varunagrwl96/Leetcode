class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prodleft = new int[n+1];
        int[] prodright = new int[n+1];
        int[] ans = new int[n];
        prodleft[0]=1;
        prodright[n-1]=1;
        for(int i=1;i<n;i++){
            prodleft[i] = prodleft[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            prodright[i] = prodright[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            ans[i] = prodleft[i]*prodright[i];
        }
        return ans;
        // System.out.println(n);
        // return null;
    }
}