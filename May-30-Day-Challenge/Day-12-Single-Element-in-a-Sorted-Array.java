O(n) time & O(1) space complexity
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int size=nums.length;
        if(size==1) return nums[0];
        for(int i=0;i<size;i=i+2){
            if(i==size-1 || nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
}
-------------------------------------------
O(logn) time & O(1) space complexity
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int size=nums.length;
        int start=0;
        int end = size-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if (mid % 2 == 1) mid--;
            if(nums[mid]==nums[mid+1]){
                start=mid+2;
            }else{
                end=mid;
            }
        }
        return nums[start];
    }
}
-----------------------------------
Easier to understand
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        
        while(left <= right && left < len && right >= 0){
            int mid = left + (right - left)/2;
            
            if((mid-1 >= 0 && nums[mid-1] == nums[mid]) || (mid + 1 < len && nums[mid+1] == nums[mid])){ // nums[mid] is not single
                int currLen = right - left; // actual length - 1                
                if((currLen/2) % 2 == 0){
                    if(nums[mid-1] == nums[mid]){
                        // The element is on the left hand side
                        right = mid - 2; // Skip mid-1 and mid as we know they are not single
                    }
                    else{
                        // The element is on the right hand side
                        left = mid + 2;
                    }
                }
                else{
                    if(nums[mid-1] == nums[mid]){
                        // The element is on the right hand side
                        left = mid + 1; // Skip mid
                    }
                    else{
                        // The element is on the left hand side
                        right = mid - 1;
                    }
                }
            }
            else return nums[mid];
        }
        
        return nums[left];
    }
}