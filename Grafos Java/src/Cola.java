import java.util.LinkedList;

public class Cola {
    private LinkedList<Integer> elementos = new LinkedList<>();

    // Agregar un elemento a la cola
    public void encolar(int elemento) {
        elementos.addLast(elemento);
    }

    // Obtener y eliminar el elemento al frente de la cola
    public int desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos.removeFirst();
    }

    // Obtener el elemento al frente de la cola sin eliminarlo
    public int frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos.getFirst();
    }

    // Verificar si la cola está vacía
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    // Obtener el tamaño de la cola
    public int tamano() {
        return elementos.size();
    }


}
