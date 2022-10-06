class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n){
            if(nums[i]>=1 && nums[i]<n && nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }else{
                i++;
            }
        }
        i=0;
        while(i<n){
            if(nums[i]!=i+1){
                return i+1;
            }else{
                i++;
            }
        }
        return i+1;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
        // int n=nums.length;
        // int[] arr = new int[n+1];
        // List<Integer> list = new ArrayList();
        // for(int i=0;i<n;i++){
        //     if(nums[i]>0 && nums[i]<=n){
        //         arr[nums[i]]++;
        //     }
        // }
        // int i=1;
        // for(i=1;i<=n;i++){
        //     if(arr[i]==0){
        //         return i;
        //     }
        // }
        // return i;
    // }
}