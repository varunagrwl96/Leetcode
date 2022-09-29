class Solution {
    public int expressiveWords(String s, String[] words) {
        if(s==null) return 0;
        int count=0;
        for(String word : words){
            if(isStretchy(word,s)){
                count++;
            }
        }
        return count;
    }
    
    public boolean isStretchy(String word, String input){
        int i=0;
        int j=0;
        while(i<word.length() && j<input.length()){
            if(word.charAt(i)==input.charAt(j)){
                int len1 = getRepeatedLength(word,i);
                int len2 = getRepeatedLength(input,j);
                if(len2<3 && len1!=len2 || len2>=3 && len2<len1){
                    return false;
                }
                i=i+len1;
                j=j+len2;
            }else{
                return false;
            }
        }
        if(i!=word.length() || j!=input.length()){
            return false;
        }
        return true;
    }
    
    public int getRepeatedLength(String word, int index){
        int x=index;
        while(x<word.length() && word.charAt(x)==word.charAt(index)){
            x++;
        }
        return x-index;
    }
}