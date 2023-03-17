package Model.ADTs;

import Model.MyException;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyDictionary<K, V> implements MyIDictionary<K, V>{
    Map<K, V> dict;

    public MyDictionary (){
        dict = new HashMap<K, V>();
    }

    @Override
    public void add(K key, V value) {
        dict.put(key, value);
    }

    @Override
    public void remove(K key) {
        dict.remove(key);
    }

    @Override
    public void update(K key, V newValue){
        dict.put(key, newValue);
    }

    @Override
    public V getValue(K key) throws MyException {
        V val = dict.get(key);
        if (val == null)
            throw new MyException("Invalid key!!");

        return val;
    }

    @Override
    public boolean isDefined(K key) {
        V val = dict.get(key);
        return val != null;
    }

    @Override
    public Set<K> keySet() {
        return dict.keySet();
    }

    @Override
    public String toString() {
        return dict.toString();
    }
}
