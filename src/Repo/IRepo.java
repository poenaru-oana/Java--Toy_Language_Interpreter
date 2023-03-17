package Repo;
import Model.MyException;
import Model.PrgState;

public interface IRepo {

    PrgState getCurrentProgram();
    void logProgramState() throws MyException;
}
