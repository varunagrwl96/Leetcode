class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        for(int i=0;i<s.length();i++){
            HashSet<Character> hashset = new HashSet();
            // hashset.add(s.charAt(i));
            for(int j=i;j<s.length();j++){
                if(!hashset.contains(s.charAt(j))){
                    hashset.add(s.charAt(j));
                    max=Math.max(max,j-i+1);
                }else{
                    break;
                }
            }
        }
        return max;
    }
}