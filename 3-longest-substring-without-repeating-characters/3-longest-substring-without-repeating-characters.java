class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int start=0;
        int end=0;
        int max=0;
        int[] arr = new int[128];
        while(end<s.length()){
            if(arr[s.charAt(end)]==0){
                arr[s.charAt(end)]++;
                end++;
                max = Math.max(max,end-start);
            }else{
                while(s.charAt(start)!=s.charAt(end)){
                    arr[s.charAt(start)]--;
                    start++;
                }
                arr[s.charAt(start)]--;
                start++;
            }
        }
        return max;
    }
}