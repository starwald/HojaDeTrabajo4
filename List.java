package HojaDeTrabajo4;

public interface List<T> {
    
    void addLast(T element);

    T removeLast();

    T getLast();

    boolean isEmpty();

    int size();

    void clear();
}
