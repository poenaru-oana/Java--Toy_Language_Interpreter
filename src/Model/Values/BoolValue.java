package Model.Values;

import Model.Type.BoolType;
import Model.Type.Type;


public class BoolValue implements Value{
    boolean value;

    public BoolValue(boolean val) {
        value = val;
    }

    public boolean getValue(){
        return value;
    }

    @Override
    public Type getType() {
        return new BoolType();
    }

    @Override
    public boolean equals(Object another){
        if(another instanceof BoolValue)
            return ((BoolValue) another).value == getValue();

        return false;
    }

    public String toString(){
        return Boolean.toString(value);
    }
}
