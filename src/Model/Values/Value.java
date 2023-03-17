package Model.Values;

import Model.Type.Type;

public interface Value {

    boolean equals (Object another);

    Type getType();
}
