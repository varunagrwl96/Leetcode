class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int length =arr.length;
        int len1=0,len2=0, len=0;
        int max=0;
        int start=0,end=0;
        for(int i=0;i<length;i++){
            len1 = expandFromMiddle(s,i,i);
            len2 = expandFromMiddle(s,i,i+1);
            System.out.println(len1 + " " + len2);
            len=Math.max(len1,len2);
            if(len>max){
                max = len;
                start=i-((len-1)/2);
                end=i+(len/2);
            }
        }
        return s.substring(start,end+1);
    }
        
        public int expandFromMiddle(String s, int start, int end){
            while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
                start--;
                end++;
            }
            return end-start-1;
        }
}
// O(n^2)
//O(1)