class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hashset = new HashSet();
        for(int i=0;i<n;i++){
            hashset.add(nums[i]);
        }
        int maxstreak=0;
        for(int num : hashset){
            if(!hashset.contains(num-1)){ //idea - For a num in set, if num-1 exists, then we have already considered it as part of streak, if it doesnt exist -> then check for the streak
                int curr = num;
                int streak=1;
                while(hashset.contains(curr+1)){
                    streak++;
                    curr++;
                }
            maxstreak = Math.max(maxstreak,streak);
            }
        }
        return maxstreak;
    }
}
//O(n)
//O(n)