package HojaDeTrabajo4;

public class StackList<T> implements Stack<T> {
    
    private List<T> list;

    public StackList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        this.list = list;
    }

    @Override
    public void push(T element) {
        list.addLast(element);
        System.out.println("Push (List): " + element);
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        return list.removeLast();
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
