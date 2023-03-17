package Model.ADTs;

import Model.MyException;

import java.util.Set;

public interface MyIDictionary<K, V> {

    void add (K key, V value);
    void remove (K key);
    void update (K key, V newValue);
    V getValue(K key) throws MyException;

    boolean isDefined(K key);

    Set<K> keySet();
}
