package Model.ADTs;

import Model.Statements.IStmt;

import java.util.List;

public interface MyIStack<T> {

    void push (T program);
    T pop();
    boolean isEmpty();
    List<T> getReversed();
}
