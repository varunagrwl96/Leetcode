class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        // HashMap<Character,Integer> hashmap = new HashMap();
        for(char c : s.toCharArray()){
            count[c]++;
            // if(hashmap.containsKey(c)){
            //     hashmap.put(c,hashmap.get(c)+1);
            // }else{
            //     hashmap.put(c,1);
            // }
        }
        int ans=0;
        boolean odd=false;
        for(int c : count){
            if(c%2==0){
                ans=ans+c;
            }else if(c/2 >=1){
                ans = ans + (c/2)*2;
                odd=true;
            }else{
                odd=true;
            }
        }
        if(odd){
            return ans+1;
        }else{
            return ans;
        }
        // boolean odd = false;
        // for(char c : hashmap.keySet()){
        //     if(hashmap.get(c)%2==0){
        //         ans= ans+hashmap.get(c);
        //     }else if(hashmap.get(c)/2>=1){
        //         ans= ans+(hashmap.get(c)/2)*2;
        //         hashmap.put(c,1);
        //         odd=true;
        //     }
        //     else{
        //         odd=true;
        //     }
        // }
        // if(odd){
        //     return ans+1;
        // }else{
        //     return ans;
        // }
    }
}

//Time - O(n)
//Space - O(1)