class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack();
        int count=0;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    count++;
                }else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
            count++;
        }
        return count;
    }
}