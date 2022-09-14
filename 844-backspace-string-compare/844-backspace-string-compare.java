class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack();
        Stack<Character> stackT = new Stack();
        for(char c : s.toCharArray()){
            if(c=='#'){
                if(!stackS.isEmpty()){
                    stackS.pop();
                }
            }else{
                stackS.push(c);
            }
        }
        for(char c : t.toCharArray()){
            if(c=='#'){
                if(!stackT.isEmpty()){
                    stackT.pop();
                }
            }else{
                stackT.push(c);
            }
        }
        return stackS.equals(stackT);
    }
}