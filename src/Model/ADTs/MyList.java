package Model.ADTs;

import java.util.ArrayList;

public class MyList<T> implements MyIList<T>{
    ArrayList<T> list;

    public MyList(){
        list = new ArrayList<T>();
    }

    @Override
    public void add(T elem) {
        list.add(elem);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T get(int i) {
        return list.get(i);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
