package Repo;

import Model.MyException;
import Model.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Repo implements IRepo{

    private List<PrgState> repo;
    String logFilePath;

    public Repo (PrgState program, String path) {

        logFilePath = path;
        repo = new ArrayList<PrgState>();
        repo.add(program);
    }

    @Override
    public PrgState getCurrentProgram() {
        return repo.get(0);
    }

    @Override
    public void logProgramState() throws MyException {
        FileWriter fW;
        try
        {
            fW = new FileWriter(logFilePath, true);
        } catch (IOException e) {
            throw new MyException("Log file cannot be opened");
        }
        var logFile = new PrintWriter(new BufferedWriter(fW));

        //log the program state
        logFile.append(getCurrentProgram().toStringFile()).append("\n\n");
        logFile.close();

    }
}
