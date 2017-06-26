/**
 * Created by jniu on 6/25/17.
 */
public class MinStack {
    private Deque<int[]> dq;

    /** initialize your data structure here. */
    public MinStack() {
        dq = new ArrayDeque<int[]>();
    }

    public void push(int x) {
        if(dq.isEmpty()) {
            dq.push(new int[]{x, x});
        } else {
            int min = Math.min(x, dq.peek()[1]);
            dq.push(new int[]{x, min});
        }
    }

    public void pop() {
        dq.pop();
    }

    public int top() {
        return dq.peek()[0];
    }

    public int getMin() {
        return dq.peek()[1];
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


private class MinStack2 {
    private Deque<Long> dq;
    private long min;

    /** initialize your data structure here. */
    public MinStack() {
        dq = new ArrayDeque<Long>();
    }

    public void push(int x) {
        if(dq.isEmpty()){
            dq.push(0L);
            min = x;
        }else{
            dq.push(x-min);
            if(x<=min) min = x;
        }
    }

    public void pop() {
        long i = dq.pop();
        if(i<=0) min = min - i;
    }

    public int top() {
        long i = dq.peek();
        if(i>=0){
            return (int)(i+min);
        } else {
            return (int)min;
        }
    }

    public int getMin() {
        return (int)min;
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