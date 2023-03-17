package Model.ADTs;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.util.Collections.reverse;

public class MyStack<T> implements MyIStack<T>{

    Stack<T> stack;

    public MyStack() {
        stack = new Stack<T>();
    }

    @Override
    public void push(T program) {
        stack.push(program);
    }

    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public List<T> getReversed() {
        var list = new ArrayList<T>(stack);
        reverse(list);
        return list;
    }

}
