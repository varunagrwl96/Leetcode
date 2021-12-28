class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(!stack.isEmpty() && curr==stack.peek()){
                stack.pop();
            }else{
                stack.push(curr);
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty()){
            char curr = stack.pop();
            ans.append(curr);
        }
        return ans.reverse().toString();
    }
}