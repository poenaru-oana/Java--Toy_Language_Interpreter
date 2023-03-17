package Model.Statements;

import Model.Expressions.Expression;
import Model.MyException;
import Model.PrgState;
import Model.Type.IntType;
import Model.Type.StringType;
import Model.Values.IntValue;
import Model.Values.StringValue;

import java.io.IOException;

public class ReadFile implements IStmt {
    Expression exp;
    String variableName;

    public ReadFile(Expression exp, String variableName) {
        this.exp = exp;
        this.variableName = variableName;
    }

    public PrgState execute(PrgState state) throws MyException {
        var symTable = state.getSymTable();
        var fileTable = state.getFileTable();

        if (symTable.isDefined(variableName)) {
            var val = symTable.getValue(variableName);

            if (val.getType().equals(new IntType())) {
                var expValue = exp.eval(symTable);
                if (expValue.getType().equals(new StringType())) {
                    var fileName = (StringValue) expValue;
                    if (fileTable.isDefined(fileName)) {
                        var reader = fileTable.getValue(fileName);
                        String line = null;
                        try {
                            line = reader.readLine();
                        }
                        catch (IOException e) {
                            throw new MyException(e.toString());
                        }
                        if (line == null)
                            symTable.update(variableName, new IntValue(0));
                        else
                            symTable.update(variableName, new IntValue(Integer.parseInt(line)));

                        return state;
                    }
                }
            }
        }
        throw new MyException("Error reading from file " + exp.toString());
    }

    @Override
    public String toStringFile() {
        return "readFile(" + exp.toString() + ", " + variableName + ")\n";
    }

    public String toString() {
        return "readFile(" + exp.toString() + ", " + variableName + ")";
    }

}
