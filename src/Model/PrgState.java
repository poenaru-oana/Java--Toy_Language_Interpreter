package Model;
import Model.ADTs.MyIDictionary;
import Model.ADTs.MyIList;
import Model.ADTs.MyIStack;
import Model.Statements.IStmt;
import Model.Values.StringValue;
import Model.Values.Value;

import java.io.BufferedReader;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Value> symTable;
    private MyIDictionary<StringValue, BufferedReader> fileTable;
    private MyIList<Value> out;
    IStmt originalProgram; //optional field, but good to have


    public MyIStack<IStmt> getExeStack() {
        return exeStack;
    }

    public void setExeStack(MyIStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public MyIDictionary<String, Value> getSymTable() {
        return symTable;
    }

    public void setSymTable(MyIDictionary<String, Value> symTable) {
        this.symTable = symTable;
    }

    public MyIDictionary<StringValue, BufferedReader> getFileTable() {
        return fileTable;
    }

    public void setFileTable(MyIDictionary<StringValue, BufferedReader> fileTable) {
        this.fileTable = fileTable;
    }

    public MyIList<Value> getOut() {
        return out;
    }

    public void setOut(MyIList<Value> out) {
        this.out = out;
    }



    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Value> symtbl, MyIDictionary<StringValue, BufferedReader> fTbl, MyIList<Value> ot, IStmt prg) {
        exeStack = stk;
        symTable = symtbl;
        fileTable = fTbl;
        out = ot;
        originalProgram = prg;//recreate the entire original prg //IT HAD DEEPCOPY BEFORE, SEE HOW TO DO THAT
        stk.push(prg);
    }

    @Override
    public String toString (){
        return  "ExeStack: " + exeStack.getReversed() +
                "\nSymTable: " + symTable +
                "\nFileTable: " + fileTable +
                "\nOutput: " + out + '\n';
    }

    public String toStringFile() throws MyException {
        StringBuilder programState = new StringBuilder();
        programState.append("ExeStack:\n");
        for (var s : exeStack.getReversed()) {
            programState.append(s.toStringFile()).append("\n");
        }
        //programState.append("ExeStack END\n");

        programState.append("SymTable:\n");
        for (var k : symTable.keySet()) {
            programState.append(k).append(" --> ").append(symTable.getValue(k)).append("\n");
        }
        //programState.append("SymTable END\n");

        programState.append("Out:\n");
        for (int i = 0; i < out.size(); i++) {
            programState.append(out.get(i)).append("\n");
        }
        //programState.append("Out END\n");

        programState.append("FileTable:\n");
        for (var k : fileTable.keySet()) {
            programState.append(k).append("\n");
        }

        return programState.toString();
    }
}
