package Model.Expressions;

import Model.ADTs.MyIDictionary;
import Model.MyException;
import Model.Type.BoolType;
import Model.Values.BoolValue;
import Model.Values.Value;

public class LogicExpression implements Expression {

    Expression exp1, exp2;

    int op; //1 = or,  2 = and

    public LogicExpression(Expression exp1, Expression exp2, int op) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.op = op;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> symTable) throws MyException {
        Value eval1 = exp1.eval(symTable);
        Value eval2 = exp2.eval(symTable);

        if(eval1.getType().equals(new BoolType())) {
            if (eval2.getType().equals(new BoolType())){
                BoolValue elem1 = (BoolValue) eval1;
                BoolValue elem2 = (BoolValue) eval2;

                if (op == 1) return new BoolValue(elem1.getValue() || elem2.getValue()) ;
                if (op == 2) return new BoolValue(elem1.getValue() && elem2.getValue()) ;
            }
            else throw new MyException("Second operand is not boolean!!");
        }
        else throw new MyException("First operand is not a boolean!!");

        throw new MyException("Operand error!!");
    }

    @Override
    public String toString() {

        if (op == 1)
            return exp1.toString() + "||" + exp2.toString();
        else if (op == 2)
            return exp1.toString() + "&&" + exp2.toString();

        return "Invalid operand!!";
    }
}
