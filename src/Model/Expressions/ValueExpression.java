package Model.Expressions;

import Model.ADTs.MyIDictionary;
import Model.MyException;
import Model.Values.Value;

public class ValueExpression implements Expression{

    Value value;

    public ValueExpression(Value val) {
        value = val;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> symTable) throws MyException {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
