//ASSIGNMENT STATEMENT
package Model.Statements;

import Model.Expressions.Expression;
import Model.MyException;
import Model.PrgState;
import Model.Type.Type;
import Model.Values.Value;

public class AssignStmt implements IStmt {
    String var;
    Expression exp;

    public AssignStmt (String variable, Expression e){
        var = variable;
        exp = e;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        var symTbl = state.getSymTable();

        if (symTbl.isDefined(var)) {
            Value val = exp.eval(symTbl);
            Type typVar = (symTbl.getValue(var)).getType();

            if ((val.getType()).equals(typVar))
                symTbl.update(var, val);
            else
                throw new MyException("Declared type of variable " + var + " and type of  the assigned expression do not match!!");
        }
        else
            throw new MyException("The used variable " + var + " was not declared before!!");

        return state;
    }

    @Override
    public String toStringFile() {
        return var + "=" + exp.toString() + "\n";
    }

    public String toString() {
        return var + "=" + exp.toString();
    }
}
