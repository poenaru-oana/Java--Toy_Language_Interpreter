package Model.Expressions;

import Model.ADTs.MyIDictionary;
import Model.MyException;
import Model.Values.Value;

public class VariableExpression implements Expression{

    String var;

    public VariableExpression(String v){
        var = v;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> symTable) throws MyException {
        return symTable.getValue(var);
    }

    @Override
    public String toString() {
        return var;
    }
}
