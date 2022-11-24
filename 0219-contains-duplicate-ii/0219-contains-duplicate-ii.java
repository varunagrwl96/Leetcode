class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //Store k elements in hashset; if hashset size >k, remove the element at nums[i-k], if hashset contains number, return true
        HashSet<Integer> hashset = new HashSet();
        for(int i=0;i<nums.length;i++){
            if(hashset.contains(nums[i])){
                return true;
            }
            hashset.add(nums[i]);
            if(hashset.size()>k){
                hashset.remove(nums[i-k]);
            }
        }
        return false;
    }
}