package Model.Expressions;

import Model.ADTs.MyIDictionary;
import Model.MyException;
import Model.Values.Value;

public interface Expression {
    Value eval(MyIDictionary<String, Value> symTable) throws MyException;
}
