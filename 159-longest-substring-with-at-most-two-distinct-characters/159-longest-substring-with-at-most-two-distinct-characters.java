class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int slength=s.length();
        int begin=0;
        int end=0;
        int length=0;
        HashMap<Character,Integer> hashmap = new HashMap();
        while(end<slength){
            char c = s.charAt(end);
            hashmap.put(c,hashmap.getOrDefault(c,0)+1);
            if(hashmap.size()>2){
                while(hashmap.size()>2){
                    char cbegin = s.charAt(begin);
                    if(hashmap.get(cbegin)>1){
                        hashmap.put(cbegin,hashmap.get(cbegin)-1);
                    }else{
                        hashmap.remove(cbegin);
                    }
                    begin++;
                }
            }else{
                length = Math.max(length,end-begin+1);
            }
            end++;
        }
        return length;
    }
}
//Time O(n)
//Space O(1) 26 letters