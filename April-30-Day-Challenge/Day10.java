class MinStack {
    List<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList();
    }
    
    public void push(int x) {
        stack.add(x);
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<stack.size();i++){
            if(min>stack.get(i)){
                min=stack.get(i);
            }
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 -------------------------------------------------------------------------------------------
 class MinStack {
    Stack<Pair<Integer,Integer>> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int x) {
        if(stack.size()==0){
        stack.add(new Pair(x,x));
        }else{
            stack.add(new Pair(x,Math.min(x,stack.peek().getValue())));
        }
    }
    
    public void pop() {
        stack.pop().getKey();
    }
    
    public int top() {
        return stack.peek().getKey();
    }
    
    public int getMin() {
        return stack.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */