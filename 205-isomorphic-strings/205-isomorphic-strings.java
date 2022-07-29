class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map_st = new HashMap();
        HashMap<Character,Character> map_ts = new HashMap();
        int m=s.length();
        int n=t.length();
        if(m!=n){
            return false;
        }
        for(int i=0;i<m;i++){
            char currS = s.charAt(i);
            char currT = t.charAt(i);
            if(!map_st.containsKey(currS)){
                map_st.put(currS,currT);
            }
            if(!map_ts.containsKey(currT)){
                map_ts.put(currT,currS);
            }
            if(!(map_st.get(currS)==currT && map_ts.get(currT)==currS)){
                return false;
            }
        }
        return true;
    }
}

// pt
// ai
// el