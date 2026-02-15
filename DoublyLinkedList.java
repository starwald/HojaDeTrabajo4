package HojaDeTrabajo4;

import java.util.ArrayList;

public class DoublyLinkedList<T> implements List<T> {
    
    private ArrayList<NodoDoble<T>> nodos;

    public DoublyLinkedList() {
        nodos = new ArrayList<>();
    }

    @Override
    public void addLast(T element) {
        nodos.add(new NodoDoble<> (element));
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
}
