class Solution {
    public int findMaxLength(int[] nums) {
        int size = nums.length;
        int sum = 0;
        int max = 0;
        HashMap<Integer,Integer> hm = new HashMap();
        hm.put(0,-1);
        for(int i=0;i<size;i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
            sum+=nums[i];
            if(hm.containsKey(sum)){
                int index = hm.get(sum);
                max = Math.max(max,i-index);
            }else{
                hm.put(sum,i);
            }
        }
        return max;
    }
}