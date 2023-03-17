package Model.Statements;

import Model.Expressions.Expression;
import Model.MyException;
import Model.PrgState;
import Model.Type.StringType;
import Model.Values.StringValue;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseRFile implements IStmt {
    Expression exp;

    public CloseRFile(Expression exp) {
        this.exp = exp;
    }

    public PrgState execute(PrgState state) throws MyException {
        var symTable = state.getSymTable();
        var fileTable = state.getFileTable();

        var expValue = exp.eval(symTable);
        if (expValue.getType().equals(new StringType())) {
            var fileName = (StringValue) expValue;
            if (fileTable.isDefined(fileName)) {
                BufferedReader reader = fileTable.getValue(fileName);
                try {
                    reader.close();
                }
                catch (IOException e) {
                    throw new MyException(e.toString());
                }
                fileTable.remove(fileName);
                return state;
            }
            throw new MyException("File" + expValue.toString() + "is not opened");
        }
        throw new MyException(exp.toString() + "is not of type string");
    }

    @Override
    public String toStringFile() {
        return "closeRFile(" + exp.toString() + ")\n";
    }

    public String toString() {
        return "closeRFile(" + exp.toString() + ")";
    }
}
