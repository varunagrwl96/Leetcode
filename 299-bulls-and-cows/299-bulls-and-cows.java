class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        HashMap<Character,Integer> hashmap = new HashMap();
        for(char c : secret.toCharArray()){
            hashmap.put(c,hashmap.getOrDefault(c,0)+1);
        }
        for(int i=0;i<guess.length();i++){
            char c= guess.charAt(i);
            if(hashmap.containsKey(c) && c==secret.charAt(i)){
                bulls++;
                if(hashmap.get(c)>1){
                    hashmap.put(c,hashmap.get(c)-1);
                }else{
                    hashmap.remove(c);
                }
            }
        }
        for(int i=0;i<guess.length();i++){
            char c= guess.charAt(i);
            if(hashmap.containsKey(c) && c!=secret.charAt(i)){
                cows++;
                if(hashmap.get(c)>1){
                        hashmap.put(c,hashmap.get(c)-1);
                }else{
                    hashmap.remove(c);
                }
            }
        }
        return bulls+"A"+cows+"B";
    }
}