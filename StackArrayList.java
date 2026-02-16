package HojaDeTrabajo4;

import java.util.ArrayList;

public class StackArrayList<T> implements Stack<T> {
    
    private ArrayList<T> data = new ArrayList<>();

    
    @Override
    public void push(T element) {
        data.add(element);
        System.out.println("Push (ArrayList): " + element);
    }
    
    @Override
    public T pop() {
        if (isEmpty()) return null;
        return data.remove(data.size() - 1);
    }
        
    @Override
    public T peek() {
        if (isEmpty()) return null;
        return data.get(data.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }
}
