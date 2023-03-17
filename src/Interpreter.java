import Controller.Controller;
import Model.*;
import Model.ADTs.MyDictionary;
import Model.ADTs.MyList;
import Model.ADTs.MyStack;
import Model.Expressions.ArithmeticExpression;
import Model.Expressions.ValueExpression;
import Model.Expressions.VariableExpression;
import Model.Statements.*;
import Model.Type.BoolType;
import Model.Type.IntType;
import Model.Type.StringType;
import Model.Values.BoolValue;
import Model.Values.IntValue;
import Model.Values.StringValue;
import Model.Values.Value;
import Repo.*;
import View.*;

import java.io.BufferedReader;

class Interpreter {
    public static void main(String[] args) {


        IStmt ex1 = new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExpression(new IntValue(2))), new PrintStmt(new VariableExpression("v"))));

        PrgState prg1 = new PrgState(new MyStack<IStmt>(), new MyDictionary<String, Value>(), new MyDictionary<StringValue, BufferedReader>(), new MyList<Value>(), ex1);
        IRepo repo1 = new Repo(prg1, "log1.txt");
        Controller ctr1 = new Controller(repo1);


        IStmt ex2 = new CompStmt(new VarDeclStmt("a", new IntType()),
                new CompStmt(new VarDeclStmt("b", new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithmeticExpression('+', new ValueExpression(new IntValue(2)), new
                                ArithmeticExpression('*', new ValueExpression(new IntValue(3)), new ValueExpression(new IntValue(5))))),
                                new CompStmt(new AssignStmt("b", new ArithmeticExpression('+', new VariableExpression("a"), new ValueExpression(new
                                        IntValue(1)))), new PrintStmt(new VariableExpression("b"))))));

        PrgState prg2 = new PrgState(new MyStack<IStmt>(), new MyDictionary<String, Value>(), new MyDictionary<StringValue, BufferedReader>(), new MyList<Value>(), ex2);
        IRepo repo2 = new Repo(prg2, "log2.txt");
        Controller ctr2 = new Controller(repo2);

        IStmt ex3 = new CompStmt(new VarDeclStmt("a", new BoolType()),
                new CompStmt(new VarDeclStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("a", new ValueExpression(new BoolValue(true))),
                                new CompStmt(new IfStmt(new VariableExpression("a"), new AssignStmt("v", new ValueExpression(new
                                        IntValue(2))), new AssignStmt("v", new ValueExpression(new IntValue(3)))), new PrintStmt(new
                                        VariableExpression("v"))))));

        PrgState prg3 = new PrgState(new MyStack<IStmt>(), new MyDictionary<String, Value>(), new MyDictionary<StringValue, BufferedReader>(), new MyList<Value>(), ex3);
        IRepo repo3 = new Repo(prg3, "log3.txt");
        Controller ctr3 = new Controller(repo3);

        IStmt ex4 = new CompStmt(new VarDeclStmt("varf", new StringType()), new CompStmt(new AssignStmt("varf", new ValueExpression(new StringValue("test.in"))),
                new CompStmt(new OpenRFile(new VariableExpression("varf")), new CompStmt(new VarDeclStmt("varc", new IntType()), new CompStmt(
                        new ReadFile(new VariableExpression("varf"), "varc"), new CompStmt(new PrintStmt(new VariableExpression("varc")), new CompStmt(
                        new ReadFile(new VariableExpression("varf"), "varc"), new CompStmt(new PrintStmt(new VariableExpression("varc")), new CloseRFile(
                        new VariableExpression("varf"))))))))));

        PrgState prg4 = new PrgState(new MyStack<IStmt>(), new MyDictionary<String, Value>(), new MyDictionary<StringValue, BufferedReader>(), new MyList<Value>(), ex4);
        IRepo repo4 = new Repo(prg4, "log4.txt");
        Controller ctr4 = new Controller(repo4);


        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1", ex1.toString(), ctr1));
        menu.addCommand(new RunExample("2", ex2.toString(), ctr2));
        menu.addCommand(new RunExample("3", ex3.toString(), ctr3));
        menu.addCommand(new RunExample("4","\nstring varf; varf=\"test.in\"; \nopenRFile(varf); \nint varc; \nreadFile(varf,varc); print(varc); \nreadFile(varf,varc); print(varc) \ncloseRFile(varf)\n",ctr4));
        menu.show();
    }
}