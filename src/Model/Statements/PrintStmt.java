//PRINT STATEMENT
package Model.Statements;
import Model.Expressions.Expression;
import Model.Expressions.VariableExpression;
import Model.MyException;
import Model.PrgState;

public class PrintStmt implements IStmt {
    Expression exp;

    public PrintStmt(Expression e) {
        exp = e;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        var out = state.getOut();
        var symTable = state.getSymTable();

        out.add(exp.eval(symTable));

        return state;
    }

    @Override
    public String toStringFile() {
        return "print(" + exp.toString() + ")\n";
    }

    @Override
    public String toString() {
        return "print(" + exp.toString() + ")";
    }


}
