class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // int slength = s.length();
        // int plength = p.length();
        // List<Integer> ans = new ArrayList();
        // HashMap<Character,Integer> smap = new HashMap();
        // HashMap<Character,Integer> pmap = new HashMap();
        // for(char c : p.toCharArray()){
        //     if(pmap.containsKey(c)){
        //         pmap.put(c,pmap.get(c)+1);
        //     }else{
        //         pmap.put(c,1);
        //     }
        // }
        // for(int i=0;i<slength;i++){
        //     char curr = s.charAt(i);
        //     if(smap.containsKey(curr)){
        //         smap.put(curr,smap.get(curr)+1);
        //     }else{
        //         smap.put(curr,1);
        //     }
        //     if(i>=plength){
        //         curr = s.charAt(i-plength);
        //         if(smap.get(curr)>1){
        //             smap.put(curr,smap.get(curr)-1);
        //         }else{
        //             smap.remove(curr);
        //         }
        //     }
        //     if(smap.equals(pmap)){
        //         ans.add(i-plength+1);
        //     }
        // }
        // return ans;
        
        int slength=s.length();
        int plength = p.length();
        List<Integer> ans = new ArrayList();
        HashMap<Character,Integer> pmap = new HashMap();
        for(char c : p.toCharArray()){
            if(pmap.containsKey(c)){
                pmap.put(c,pmap.get(c)+1);
            }else{
                pmap.put(c,1);
            }
        }
        int left=0, right=0;
        int counter = pmap.size();
        while(right<slength){
            char curr = s.charAt(right);
            if(pmap.containsKey(curr)){
                pmap.put(curr,pmap.get(curr)-1);
                if(pmap.get(curr)==0){
                    counter--;
                }
            }
            right++;
            while(counter==0){
                char curr2 = s.charAt(left);
                if(pmap.containsKey(curr2)){
                    if(pmap.get(curr2)==0){
                        counter++;
                    }
                    pmap.put(curr2,pmap.get(curr2)+1);
                    // if(pmap.get(curr2)>0){
                    //     counter++;   
                    // }
                }
                if(right-left==plength){
                    ans.add(left);
                }
                left++;
            }

        }
        return ans;
    }
}

//Time O(ns+np)
//Space O(1) Space is constant 26 letters