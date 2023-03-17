//package View;
//
//
//import Controller.Controller;
//import Model.ADTs.*;
//import Model.Expressions.*;
//import Model.PrgState;
//import Model.Statements.*;
//import Model.Type.*;
//import Model.Values.*;
//import Repo.Repo;
//
//import java.util.Scanner;
//
//public class View {
//    Controller controller;
//
//
//
//    IStmt ex2 = new CompStmt(new VarDeclStmt("a", new IntType()),
//            new CompStmt(new VarDeclStmt("b", new IntType()),
//                    new CompStmt(new AssignStmt("a", new ArithmeticExpression('+', new ValueExpression(new IntValue(2)), new
//                            ArithmeticExpression('*', new ValueExpression(new IntValue(3)), new ValueExpression(new IntValue(5))))),
//                            new CompStmt(new AssignStmt("b", new ArithmeticExpression('+', new VariableExpression("a"), new ValueExpression(new
//                                    IntValue(1)))), new PrintStmt(new VariableExpression("b"))))));
//
//    IStmt ex3 = new CompStmt(new VarDeclStmt("a", new BoolType()),
//            new CompStmt(new VarDeclStmt("v", new IntType()),
//                    new CompStmt(new AssignStmt("a", new ValueExpression(new BoolValue(true))),
//                            new CompStmt(new IfStmt(new VariableExpression("a"), new AssignStmt("v", new ValueExpression(new
//                                    IntValue(2))), new AssignStmt("v", new ValueExpression(new IntValue(3)))), new PrintStmt(new
//                                    VariableExpression("v"))))));
//
//    public View() {
//        this.controller = null;
//    }
//
//    void runProgram(IStmt program) {
//        var stack = new MyStack<IStmt>();
//        var symTable = new MyDictionary<String, Value>();
//        var out = new MyList<Value>();
//        PrgState program1 = new PrgState(stack, symTable, out, program);
//
//        Repo repo = new Repo(program1, "log1.txt");
//        controller = new Controller(repo);
//        controller.allSteps();
//    }
//
//    public void run() {
//        while (true) {
//            System.out.println("1. int v; v=2;Print(v)");
//            System.out.println("2. int a;int b; a=2+3*5;b=a+1;Print(b)");
//            System.out.println("3. bool a; int v; a=true;(If a Then v=2 Else v=3);Print(v)");
//            System.out.println("0. Exit");
//
//            var scanner = new Scanner(System.in);
//            int option = scanner.nextInt();
//
//            switch (option) {
//                case 0:
//                    return;
//                case 1:
//                    runProgram(ex1);
//                    break;
//                case 2:
//                    runProgram(ex2);
//                    break;
//                case 3:
//                    runProgram(ex3);
//                    break;
//
//            }
//        }
//    }
//}