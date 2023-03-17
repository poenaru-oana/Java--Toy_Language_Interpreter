//IF STATEMENT
package Model.Statements;

import Model.Expressions.Expression;
import Model.MyException;
import Model.PrgState;
import Model.Type.BoolType;
import Model.Values.BoolValue;

public class IfStmt implements IStmt{

    Expression expr;
    IStmt thenSt, elseSt;

    public IfStmt(Expression e, IStmt thenS, IStmt elseS){
        expr = e;
        thenSt = thenS;
        elseSt = elseS;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        var symTable = state.getSymTable();
        var exeStack = state.getExeStack();

        if(!expr.eval(symTable).getType().equals(new BoolType()))
            throw new MyException("Expression is not boolean!!");

        BoolValue value = (BoolValue) expr.eval(symTable);

        if (value.getValue())
            exeStack.push(thenSt);
        else
            exeStack.push(elseSt);

        return state;
    }

    @Override
    public String toStringFile() {
        return "if(" + expr.toString() + ")\n   then(" + thenSt.toString() + ")\n   else(" + elseSt.toString() + ")\n";
    }

    @Override
    public String toString() {
        return "if(" + expr.toString() + ") then(" + thenSt.toString() + ") else(" + elseSt.toString() + ')';
    }
}
