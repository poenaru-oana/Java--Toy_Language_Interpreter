package Model.Expressions;

import Model.ADTs.MyIDictionary;
import Model.MyException;
import Model.Type.IntType;
import Model.Values.IntValue;
import Model.Values.Value;
import jdk.jfr.Experimental;

public class ArithmeticExpression implements Expression {

    Expression exp1, exp2;
    char op;

    public ArithmeticExpression(char op, Expression exp1, Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.op = op;
    }


    @Override
    public Value eval(MyIDictionary<String, Value> symTable) throws MyException {
        Value v1, v2;
        v1 = exp1.eval(symTable);

        if (v1.getType().equals(new IntType())) {
            v2 = exp2.eval(symTable);
            if(v2.getType().equals(new IntType())){
                int elem1 = ((IntValue) v1).getValue();
                int elem2 = ((IntValue) v2).getValue();

                if (op == '+') return new IntValue(elem1 + elem2);
                if (op == '-') return new IntValue(elem1 - elem2);
                if (op == '*') return new IntValue(elem1 * elem2);
                if (op == '/') {
                    if (elem2 == 0)
                        throw new MyException("Division by zero!!");

                    return new IntValue(elem1 / elem2);
                }
            }
            else throw new MyException("Second operand is not integer!!");
        }
        else throw new MyException("First operand is not integer!!");

        throw new MyException("Operand error!!");
    }

    @Override
    public String toString() {
        return exp1.toString() + op + exp2.toString();
    }
}
