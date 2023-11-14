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



    public int caminoCorto(int a, int b){

        int distancia =0;
        boolean desvis = false;
        int[] visitados = new int[numNodos];

        for(int i=0; i<=numNodos;i++){
            visitados[i]=i;
        }

        while()



        /*
        int distancia = 0;
        boolean fin = false;
        if(verificarAdyacencia(a,b)){
            return 1;
        }
        else {
            while (!fin) {
                for (int i = ; i <= numNodos; i++) {
                    for(int j=0; j<= numNodos; j++){
                        if(verificarAdyacencia(i,j)){
                            fin=true;

                        }
                    }
                    distancia++;
                }
            }
        }


        //System.out.println("La distancia camino mas corto es: " + distancia);
        return distancia;*/
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



