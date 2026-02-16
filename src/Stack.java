public interface Stack<T> {

    T pop();

    void push(T element);

    T peek();

    boolean isEmpty();

    int size();

    void clear();
}
