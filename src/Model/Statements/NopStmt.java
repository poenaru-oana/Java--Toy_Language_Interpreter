//NO OP STATEMENT
package Model.Statements;
import Model.MyException;
import Model.PrgState;

public class NopStmt implements IStmt{
    @Override
    public PrgState execute(PrgState state) throws MyException {
        return state;
    }

    @Override
    public String toStringFile() {
        return null;
    }
}
