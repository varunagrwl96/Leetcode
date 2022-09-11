class Solution {
    public int characterReplacement(String s, int k) {
        int slength = s.length();
        int begin=0;
        int end=0;
        int ans=0;
        HashMap<Character,Integer> count = new HashMap();
        int maxFreq=0;
        while(end<slength){
            char c=s.charAt(end);
            count.put(c,count.getOrDefault(c,0)+1);
            // int maxFreq = getMostFreqCount(count);
            maxFreq = Math.max(maxFreq,count.get(c));
            if(end-begin+1-maxFreq <= k){  //len of window - maxfreq <= k (valid)
                ans=Math.max(ans,end-begin+1);
            }else{
                char c2=s.charAt(begin);
                count.put(c2,count.get(c2)-1);
                begin++;
            }
            end++;
        }
        return ans;
    }
    
    public int getMostFreqCount(HashMap<Character,Integer> hashmap){
        int res=0;
        for(char c : hashmap.keySet()){
            res=Math.max(res,hashmap.get(c));
        }
        return res;
    }
}