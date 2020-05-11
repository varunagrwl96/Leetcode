O(n) time and O(n) space complexity
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size=nums.length;
        int[] left = new int[size];
        int[] right = new int[size];
        left[0]=1;
        right[size-1]=1;
        for(int i=1;i<size;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        for(int i=size-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        for(int i=0;i<size;i++){
            nums[i]=left[i]*right[i];
        }
        return nums;
    }
}

----------------------------------------------------------------------------------
Constant space complexity O(1) time complexity O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
         int size = nums.length;
        int count_zero=0;
        int product=1;
        for(int i=0;i<size;i++){
            if(nums[i]==0){
                count_zero++;
            }else{
            product*=nums[i];
            }
        }
        for(int i=0;i<size;i++){
            if(count_zero>0){
                if(count_zero>1){
                 nums[i]=0;   
                }else if(nums[i]==0){
                    nums[i]=product;
                }else{
                    nums[i]=0;
                }
                // if(count_zero>1){
                   // nums[i]=0; 
                // }else{
                    // nums[i]=product;
                // }   
            }else{
                nums[i]=product/nums[i];    
                }
            }
        return nums;
    }
}
