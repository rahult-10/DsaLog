
import java.util.Stack;

class MinStack {
    Stack<Long> st;
    long minStack;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        long value = val;
        if(st.isEmpty()){
            minStack = value;
            st.push(value);
        }
        else {
            if(value > minStack){
                st.push(value);
            }
            else {
                st.push(2*value-minStack);
                minStack = value;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        long top = st.peek();
        st.pop();
        if(top < minStack){
            minStack = 2*minStack-top;
        }
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        long top = st.peek();
        if(top >= minStack){
            return (int) top;
        }
        return (int) minStack;
    }
    
    public int getMin() {
        return (int) minStack;
    }
}