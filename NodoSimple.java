package HojaDeTrabajo4;

public class NodoSimple<T> {
    
    private T data;

    public NodoSimple(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
