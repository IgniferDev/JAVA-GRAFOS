import java.util.Scanner;

public class Grafo {
    //atributos
    private int numNodos;
    private int matrizPesos[][];
    //constructor

    public Grafo(int numNodos) {
        this.numNodos = numNodos;
        matrizPesos = new int[numNodos][numNodos];
    }


    public int dijkstra(int inicio, int fin) {
        int[] distancias = new int[numNodos];
        boolean[] visitados = new boolean[numNodos];

        // Inicialización de distancias
        for (int i = 0; i < numNodos; i++) {
            distancias[i] = Integer.MAX_VALUE;
            visitados[i] = false;
        }

        distancias[inicio - 1] = 0;

        for (int i = 0; i < numNodos - 1; i++) {
            int u = obtenerVerticeConDistanciaMinima(distancias, visitados);
            visitados[u] = true;

            for (int v = 0; v < numNodos; v++) {
                if (!visitados[v] && matrizPesos[u][v] != 0 && distancias[u] != Integer.MAX_VALUE && distancias[u] + matrizPesos[u][v] < distancias[v]) {
                    distancias[v] = distancias[u] + matrizPesos[u][v];
                }
            }
        }

        return distancias[fin - 1];
    }

    private int obtenerVerticeConDistanciaMinima(int[] distancias, boolean[] visitados) {
        int minDistancia = Integer.MAX_VALUE;
        int minVertice = -1;

        for (int v = 0; v < numNodos; v++) {
            if (!visitados[v] && distancias[v] <= minDistancia) {
                minDistancia = distancias[v];
                minVertice = v;
            }
        }

        return minVertice;
    }


    public int caminoCorto(int inicio, int objetivo) {
        int distancia = -1; // Inicializar con un valor que indique que no se ha encontrado un camino
        boolean[] visitado = new boolean[numNodos];

        // Cola para almacenar nodos a procesar junto con su distancia
        Cola c = new Cola();
        c.encolar(inicio);
        c.encolar(0); // La distancia desde el inicio hasta el inicio es 0

        while (!c.estaVacia()) {
            int nodoActual = c.desencolar();
            int distanciaActual = c.desencolar();

            // Marcar el nodo actual como visitado
            visitado[nodoActual] = true;

            // Verificar si se alcanzó el nodo objetivo
            if (nodoActual == objetivo) {
                distancia = distanciaActual;
                break;
            }

            // Explorar nodos adyacentes
            for (int i = 0; i < numNodos; i++) {
                if (verificarAdyacencia(nodoActual, i) && !visitado[i]) {
                    // Agregar el nodo adyacente a la cola junto con su distancia
                    c.encolar(i);
                    c.encolar(distanciaActual + 1);
                }
            }
        }

        if (distancia == -1) {
            System.out.println("El destino no se puede alcanzar desde el vertice de partida");
        }

        return distancia;
    }

    public int getNumNodos() {
        return numNodos;
    }

    public void setNumNodos(int numNodos) {
        this.numNodos = numNodos;

    }

    public void agregarPeso(int a, int b) {
        Scanner s = new Scanner(System.in);
        System.out.println("Peso:");
        int peso = s.nextInt();
        matrizPesos[b-1][a-1] = peso;
        matrizPesos[a-1][b-1] = peso;

    }

    public void agregarAristas() {
        Scanner s = new Scanner(System.in);
        System.out.println("Numero de aristas: ");
        int ar = s.nextInt();
        for (int i = 0; i < ar; i++) {
            System.out.println("Nodo a: ");
            int a = s.nextInt();
            System.out.println("Nodo b: ");
            int b = s.nextInt();
            agregarPeso(a, b);
        }
    }

    public void imprimirMatriz() {
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                System.out.println(matrizPesos[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public int obtenerGrado(int n) {
        int cont = 0;
        for (int j = 0; j < numNodos; j++) {
            if (matrizPesos[n-1][j] > 0) {
                cont++;
            }
        }
        return (cont);
    }

    public boolean verificarAdyacencia(int i, int j) {
        if (matrizPesos[i][j] > 0 || matrizPesos[j][i] > 0) {
            return (true);
        } else {
            return (false);
        }
    }

    public boolean verificarGrafoConexo() {
        //correccion
        boolean ret=true;
        int in=0;
        boolean[] visitados = new boolean[numNodos];
        for (int i = 0; i < numNodos; i++) {
            visitados[i] = false;
        }


        for(int i=in; i<numNodos; i++){
            for(int j=0; j<numNodos; j++){
                if (matrizPesos[i][j]!=0) {
                    visitados[i]=true;
                    in = j;
                }
            }
        }

        for(int i=0; i<numNodos; i++){
            if(visitados[i]){
                ret=true;
            }
            else{
                ret=false;
            }



        }
        return ret;

        /*boolean conexo = true;
        for (int i = 0; i < numNodos; i++) {
            for (int j = i + 1; j < numNodos; j++) {
                if (matrizPesos[i][j] <= 0 || matrizPesos[j][i] <= 0) {
                    conexo = false;
                }
            }
        }
        return (conexo);*/
    }

    public boolean verificarPesosPositivos() {
        boolean positivo = true;
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                if (matrizPesos[i][j] < 0) {
                    positivo = false;
                    break;
                }
            }
        }
        return (positivo);
    }
}



