class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeftIndex(nums,target);
        int right = findRightIndex(nums,target);
        return new int[]{left,right};
    }
    
    public int findLeftIndex(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        int startIndex=-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]>=target){
                right=mid-1;
            }else{
                left=mid+1;
            }
            if(nums[mid]==target){
                startIndex=mid;
            }
        }
        return startIndex;
    }
    
    public int findRightIndex(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        int endIndex=-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<=target){
                left=mid+1;
            }else{
                right=mid-1;
            }
            if(nums[mid]==target){
                endIndex=mid;
            }
        }
        return endIndex;
    }
}