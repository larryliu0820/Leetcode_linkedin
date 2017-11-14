import java.util.Stack;

/**
 * Created by mengwliu on 11/13/17.
 *  716. Max Stack
 */
public class p716 {
    /** initialize your data structure here. */
    Stack<Integer> numStack;
    Stack<Integer> maxStack;
    public p716() {
        numStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        numStack.push(x);
        if (!maxStack.isEmpty() && numStack.get(maxStack.peek()) > x) maxStack.push(maxStack.peek());
        else maxStack.push(maxStack.size());
    }

    public int pop() {
        int num = numStack.pop();
        maxStack.pop();
        return num;
    }

    public int top() {
        return numStack.peek();
    }

    public int peekMax() {
        return numStack.get(maxStack.peek());
    }

    public int popMax() {
        int maxInd = maxStack.pop();
        int maxVal = numStack.get(maxInd);
        numStack.remove(maxInd);
        return maxVal;
    }
}
