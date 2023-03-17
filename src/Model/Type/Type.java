package Model.Type;
import Model.Values.Value;

public interface Type {
    boolean equals (Object another);
    Value defaultValue();
    String toString();
}
