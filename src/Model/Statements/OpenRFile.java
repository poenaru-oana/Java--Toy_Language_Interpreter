package Model.Statements;

import Model.Expressions.Expression;
import Model.MyException;
import Model.PrgState;
import Model.Type.StringType;
import Model.Values.StringValue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;


public class OpenRFile implements IStmt {

    Expression exp;

    public OpenRFile (Expression e) {
        exp = e;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        var symTable = state.getSymTable();
        var fileTable = state.getFileTable();

        var expValue = exp.eval(symTable);

        if (expValue.getType().equals(new StringType())) {
            var fileName = (StringValue) expValue;
            if (fileTable.isDefined(fileName))
                throw new MyException(fileName.toString() + " is already opened");

            BufferedReader reader;

            try {
                var fR = new FileReader(fileName.getValue());
                reader = new BufferedReader(fR);
            }
            catch (FileNotFoundException e) {
                throw new MyException(fileName.getValue() + " not found");
            }

            fileTable.add(fileName,reader);
            return state;

        }
        else throw new MyException("Expression is not string type!!");
    }

    @Override
    public String toStringFile() {
        return "openRFile(" + exp.toString() + ")\n";
    }

    public String toString() {
        return "openRFile(" + exp.toString() + ")";
    }
}
