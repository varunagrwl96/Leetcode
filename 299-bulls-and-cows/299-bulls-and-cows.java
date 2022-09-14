class Solution {
    public String getHint(String secret, String guess) {
        // int bulls=0;
        // int cows=0;
        // HashMap<Character,Integer> hashmap = new HashMap();
        // for(char c : secret.toCharArray()){
        //     hashmap.put(c,hashmap.getOrDefault(c,0)+1);
        // }
        // for(int i=0;i<guess.length();i++){
        //     char c= guess.charAt(i);
        //     if(hashmap.containsKey(c) && c==secret.charAt(i)){
        //         bulls++;
        //         if(hashmap.get(c)>1){
        //             hashmap.put(c,hashmap.get(c)-1);
        //         }else{
        //             hashmap.remove(c);
        //         }
        //     }
        // }
        // for(int i=0;i<guess.length();i++){
        //     char c= guess.charAt(i);
        //     if(hashmap.containsKey(c) && c!=secret.charAt(i)){
        //         cows++;
        //         if(hashmap.get(c)>1){
        //                 hashmap.put(c,hashmap.get(c)-1);
        //         }else{
        //             hashmap.remove(c);
        //         }
        //     }
        // }
        // return bulls+"A"+cows+"B";
        
        int len = secret.length();
		int[] secretarr = new int[10];
		int[] guessarr = new int[10];
		int bull = 0, cow = 0;
		for (int i = 0; i < len; ++i) {
			if (secret.charAt(i) == guess.charAt(i)) {
				++bull;
			} else {
				++secretarr[secret.charAt(i) - '0'];
				++guessarr[guess.charAt(i) - '0'];
			}
		}
		for (int i = 0; i < 10; ++i) {
			cow += Math.min(secretarr[i], guessarr[i]);
		}
		return "" + bull + "A" + cow + "B";
    }
}
//Time O(2n)
//Space O(n) n-> letters in guess