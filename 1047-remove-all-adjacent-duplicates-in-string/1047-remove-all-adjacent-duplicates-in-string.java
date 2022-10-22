class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack();
        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(!stack.isEmpty() && stack.peek()==curr){
                stack.pop();
            }else{
                stack.push(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}