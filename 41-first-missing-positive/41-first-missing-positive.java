class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int[] arr = new int[n+1];
        List<Integer> list = new ArrayList();
        for(int i=0;i<n;i++){
            if(nums[i]>0 && nums[i]<=n){
                arr[nums[i]]++;
            }
        }
        int i=1;
        for(i=1;i<=n;i++){
            if(arr[i]==0){
                return i;
            }
        }
        return i;
    }
}