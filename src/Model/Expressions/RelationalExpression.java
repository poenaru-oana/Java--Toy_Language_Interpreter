package Model.Expressions;

import Model.ADTs.MyIDictionary;
import Model.MyException;
import Model.Type.IntType;
import Model.Values.BoolValue;
import Model.Values.IntValue;
import Model.Values.Value;

public class RelationalExpression implements Expression{
    Expression e1;
    Expression e2;
    int op; // 1 - <, 2 - <=, 3 - ==, 4 - !=, 5 - >, 6 - >=

    public RelationalExpression(Expression e1, Expression e2, int op)
    {
        this.op = op;
        this.e1 = e1;
        this.e2 = e2;
    }

    public Value eval(MyIDictionary<String, Value> table) throws MyException {
        var eval1 = e1.eval(table);
        var eval2 = e2.eval(table);

        if(eval1.getType().equals(new IntType()))
        {
            if(eval2.getType().equals(new IntType()))
            {
                var exp1 = (IntValue)eval1;
                var exp2 = (IntValue)eval2;

                if(op == 1) return new BoolValue(exp1.getValue() < exp2.getValue());
                if(op == 2) return new BoolValue(exp1.getValue() <= exp2.getValue());
                if(op == 3) return new BoolValue(exp1.getValue() == exp2.getValue());
                if(op == 4) return new BoolValue(exp1.getValue() != exp2.getValue());
                if(op == 5) return new BoolValue(exp1.getValue() > exp2.getValue());
                if(op == 6) return new BoolValue(exp1.getValue() >= exp2.getValue());
            }
            else
                throw new MyException("Second operand is not an integer");
        }else
            throw new MyException("First operand is not an integer");

        throw new MyException("Relational expression evaluation error");

    }

    public String toString()
    {
        String symbol = "<";
        if(op == 2)
            symbol = "<=";
        else if(op == 3)
            symbol = "==";
        else if(op == 4)
            symbol = "!=";
        else if(op == 5)
            symbol = ">";
        else if(op == 6)
            symbol = ">=";
        return e1.toString() + " " + symbol + " " + e2.toString();
    }
}
