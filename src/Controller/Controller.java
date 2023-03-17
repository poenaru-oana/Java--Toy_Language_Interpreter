package Controller;

import Model.ADTs.MyIStack;
import Model.MyException;
import Model.PrgState;
import Model.Statements.IStmt;
import Repo.IRepo;

public class Controller {

    private IRepo repo;

    public Controller(IRepo r) {
        repo = r;
    }

    public PrgState oneStep(PrgState state) throws MyException {
        var stack = state.getExeStack();

        if (stack.isEmpty())
            throw new MyException("Execution stack is empty!!");

        IStmt currentStatement = stack.pop();
        return currentStatement.execute(state);
    }

    public void allSteps() throws MyException {
        PrgState prg = repo.getCurrentProgram();

        repo.logProgramState();
        while (!prg.getExeStack().isEmpty()) {
            oneStep(prg);
            repo.logProgramState();
            System.out.println(prg);
        }
    }
}
