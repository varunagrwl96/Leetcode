class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()==c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        String ans="";
        while(!stack.isEmpty()){
            ans=stack.pop()+ans;
        }
        return ans;
    }
}