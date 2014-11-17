package leetCode;

import java.util.Stack;

class MinStack {
    private Stack<Integer> origin = new Stack<Integer>();
    private Stack<Integer> min    = new Stack<Integer>();
    public void push(int x) {
    	
        origin.push(x);
        if (min.empty() || min.peek() > x) {
        	min.push(x);
        }
    }

    public void pop() {
       int x = origin.pop();
       if (min.peek().equals(x)) {
    	   min.pop();
       }
    }

    public int top() {
        return origin.peek();
    }

    public int getMin() {
        return min.peek();
    }
}