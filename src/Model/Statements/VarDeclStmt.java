//VARIABLE DECLARATION STATEMENT
package Model.Statements;

import Model.MyException;
import Model.PrgState;
import Model.Type.BoolType;
import Model.Type.IntType;
import Model.Type.StringType;
import Model.Type.Type;
import Model.Values.BoolValue;
import Model.Values.IntValue;
import Model.Values.StringValue;

public class VarDeclStmt implements IStmt{
    String name;
    Type type;

    public VarDeclStmt(String nm, Type tp){
        name = nm;
        type = tp;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        var symTable = state.getSymTable();

        if (symTable.isDefined(name))
            throw new MyException("Variable " + name + " is already declared!!");

        symTable.add(name, type.defaultValue());

        return state;
    }

    @Override
    public String toStringFile() {
        return type.toString() + " " + name + '\n';
    }

    @Override
    public String toString() {
        return type.toString() + " " + name;
    }
}
