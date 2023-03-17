//COMPOUND STATEMENT
package Model.Statements;

import Model.MyException;
import Model.ADTs.MyIStack;
import Model.PrgState;

public class CompStmt implements IStmt {

    IStmt first;
    IStmt second;

    public CompStmt(IStmt frst, IStmt scnd){
        first = frst;
        second = scnd;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stack = state.getExeStack();
        stack.push(second);
        stack.push(first);
        return state;
    }

    public String toString(){
        return "(" + first.toString() + ";" + second.toString() + ")";
    }

    public String toStringFile(){
        return first.toStringFile() + second.toStringFile();
    }
}
