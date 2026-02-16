import java.util.ArrayList;

public class SinglyLinkedList<T> implements List<T> {
    
    private ArrayList<NodoSimple<T>> nodos;

    public SinglyLinkedList() {
        nodos = new ArrayList<>();
    }

    @Override
    public void addLast(T element) {
        nodos.add(new NodoSimple<> (element));
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        return nodos.remove(nodos.size() - 1).getData();
    }

    @Override
    public T getLast() {
        if (isEmpty()) return null;
        return nodos.get(nodos.size() - 1).getData();
    }

    @Override
    public boolean isEmpty() {
        return nodos.isEmpty();
    }

    @Override
    public int size() {
        return nodos.size();
    }

    @Override
    public void clear() {
        nodos.clear();
    }
}
