package HojaDeTrabajo4;

import java.util.Vector;

public class StackVector<T> implements Stack<T> {
    
    private Vector<T> data = new Vector<>();

    @Override
    public void push(T element) {
        data.add(element);
        System.out.println("Push (Vector): " + element);
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        return data.remove(data.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return data.lastElement();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }
}
