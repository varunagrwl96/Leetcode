class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }
    
    public String getString(String x){
        String res="";
        int skip=0;
            for(int i=x.length()-1;i>=0;i--){
                char c= x.charAt(i);
                if(c=='#'){
                    skip++;
                }else{
                    if(skip>0){
                        skip--;
                    }else{
                        res+=Character.toString(c);
                    }
                }
            }
        return res;
        }
        // Stack<Character> stackS = new Stack();
        // Stack<Character> stackT = new Stack();
        // for(char c : s.toCharArray()){
        //     if(c=='#'){
        //         if(!stackS.isEmpty()){
        //             stackS.pop();
        //         }
        //     }else{
        //         stackS.push(c);
        //     }
        // }
        // for(char c : t.toCharArray()){
        //     if(c=='#'){
        //         if(!stackT.isEmpty()){
        //             stackT.pop();
        //         }
        //     }else{
        //         stackT.push(c);
        //     }
        // }
        // return stackS.equals(stackT);
// }
}