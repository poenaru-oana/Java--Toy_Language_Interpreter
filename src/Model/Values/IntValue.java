package Model.Values;

import Model.Type.IntType;
import Model.Type.Type;


public class IntValue implements Value{
    int value;

    public IntValue(int val) {
        value = val;
    }

    public int getValue(){
        return value;
    }

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public boolean equals(Object another){
        if(another instanceof IntValue)
            return ((IntValue) another).value == getValue();

        return false;
    }

    public String toString(){
        return Integer.toString(value);
    }
}
