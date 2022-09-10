class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int plength = p.length();
        int slength = s.length();
        HashMap<Character,Integer> pmap = new HashMap();
        HashMap<Character,Integer> smap = new HashMap();
        for(char c: p.toCharArray()){
            pmap.put(c,pmap.getOrDefault(c,0)+1);
        }
        List<Integer> ans = new ArrayList();
        int begin=0;
        int end=0;
        while(end<slength){
            char c2=s.charAt(end);
            smap.put(c2,smap.getOrDefault(c2,0)+1);
            // if(smap.equals(pmap)){
            //     ans.add(begin);
            // }
            while(end-begin+1>plength){
                char cbeg=s.charAt(begin);
                if(smap.get(cbeg)>1){
                    smap.put(cbeg,smap.get(cbeg)-1);
                }else{
                    smap.remove(cbeg);
                }
                begin++;
            }
            if(smap.equals(pmap)){
                ans.add(begin);
            }
            end++;
        }
        return ans;
    }
}
//Time O(n)
//Space O(1)