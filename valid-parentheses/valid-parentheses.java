class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }
            else if(c=='{'){
                stack.push('}');
            }
            else if(c=='['){
                stack.push(']');
            }else if(c==')' || c=='}'|| c==']'){
                if(stack.isEmpty() || stack.pop()!=c){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}