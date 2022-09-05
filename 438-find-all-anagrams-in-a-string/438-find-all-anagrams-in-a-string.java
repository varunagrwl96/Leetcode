class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slength = s.length();
        int plength = p.length();
        List<Integer> ans = new ArrayList();
        HashMap<Character,Integer> smap = new HashMap();
        // for(char c : s.toCharArray()){
        //     if(smap.containsKey(c)){
        //         smap.put(c,smap.get(c)+1);
        //     }else{
        //         smap.put(c,1);
        //     }
        // }
        HashMap<Character,Integer> pmap = new HashMap();
        for(char c : p.toCharArray()){
            if(pmap.containsKey(c)){
                pmap.put(c,pmap.get(c)+1);
            }else{
                pmap.put(c,1);
            }
        }
        for(int i=0;i<slength;i++){
            char curr = s.charAt(i);
            if(smap.containsKey(curr)){
                smap.put(curr,smap.get(curr)+1);
            }else{
                smap.put(curr,1);
            }
            if(i>=plength){
                curr = s.charAt(i-plength);
                if(smap.get(curr)>1){
                    smap.put(curr,smap.get(curr)-1);
                }else{
                    smap.remove(curr);
                }
            }
            if(smap.equals(pmap)){
                ans.add(i-plength+1);
            }
        }
        return ans;
        
        // for(char c : a.toCharArray()){
        //     if(amap.containsKey(c)){
        //         amap.put(c,amap.get(c)+1);
        //     }else{
        //         amap.put(c,1);
        //     }
        // }
        // for(int i=0;i<=m-n;i++){
        //     if(isAnagram(s.substring(i,i+n),p)){
        //         ans.add(i);
        //     }
        // }
        // return ans;
    }
    
    public boolean isAnagram(String a, String b){
        HashMap<Character,Integer> amap = new HashMap();
        for(char c : a.toCharArray()){
            if(amap.containsKey(c)){
                amap.put(c,amap.get(c)+1);
            }else{
                amap.put(c,1);
            }
        }
        for(char c : b.toCharArray()){
            if(amap.containsKey(c)){
                if(amap.get(c)>1){
                    amap.put(c,amap.get(c)-1);
                }else{
                    amap.remove(c);
                }
            }else{
                return false;
            }
        }
        if(amap.size()>0) return false;
        return true;
    }
}