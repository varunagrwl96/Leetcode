O(n) time & space complexity
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] chars = new int[26];
        for(char c : s1.toCharArray()){
            chars[c-'a']++;
        }
        int right=0,left=0;
        while(right<s2.length()){
            if(chars[s2.charAt(right)-'a']>0){
                chars[s2.charAt(right)-'a']--;
                right++;
            }else{
                chars[s2.charAt(left)-'a']++;
                left++;
            }
            if(right-left==s1.length()){
                return true;
            }
        }
        return false;
    }
}