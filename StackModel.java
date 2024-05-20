package application;
import java.util.Stack;


public class StackModel {
    private Stack<Integer> stack;

    public StackModel() {
        stack = new Stack<>();
    }

    public void push(int item) {
        stack.push(item);
    }

    public int pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        throw new IllegalStateException("Stack is empty");
    }

    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new IllegalStateException("Stack is empty");
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public Stack<Integer> getStack() {
        return stack;
    }
}

