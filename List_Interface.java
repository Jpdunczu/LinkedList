package lab6;

public interface List_Interface<T> {

    T getAt(int index);

    T setAt(int index, T item);

    boolean isEmpty();

    int getSize();

    void clear();

    boolean contains(T item);

    void addToEnd(T item);

    void  insert(int index, T item);

    void remove(int index);

    Object[] toArray();

}