class Solution {
    public String reverseVowels(String s) {
        int i=0;
        int j=s.length()-1;
        int n=s.length();
        HashSet<Character> vowels = new HashSet();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] sarr = s.toCharArray();
        while(i<j){
            while(i<n && !vowels.contains(sarr[i])){
                i++;
            }
            
            while(j>=0 && !vowels.contains(sarr[j])){
                j--;
            }
            
            if(i<j){
                char temp = sarr[i];
                sarr[i]=sarr[j];
                sarr[j]=temp;
                i++;
                j--;
            }
        }
        return new String(sarr);
    }
}