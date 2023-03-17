package Model.Values;

import Model.Type.StringType;
import Model.Type.Type;

import java.util.Objects;

public class StringValue implements Value{

    String value;

    public StringValue(String val) {
        value = val;
    }

    public String getValue(){
        return value;
    }

    @Override
    public boolean equals(Object another) {
        if (another instanceof StringValue stringValue)
            return Objects.equals(stringValue.getValue(), getValue());

        return false;
    }

    public String toString(){
        return value;
    }

    @Override
    public Type getType() {
        return new StringType();
    }
}
