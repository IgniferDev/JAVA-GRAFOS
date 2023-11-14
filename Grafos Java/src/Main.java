import java.util.Scanner;

public class Main {
        public static void main(String[] args){



            Grafo g = new Grafo(100);

            Scanner s = new Scanner(System.in);
            int op= 0;

            do{
                System.out.println(" G R A F O S  N O  D I R I G I D O S");
                System.out.println("1. Crear Grafo");
                System.out.println("2. Agregar aristas");
                System.out.println("3. Imprimir matriz de pesos");
                System.out.println("4. Obtener Grado");
                System.out.println("5. Verificar Adyacencia");
                System.out.println("6. Verificar Grafo Convexo");
                System.out.println("7. Verificar pesos positivos");
                System.out.println("8. Longitud mas corta de un nodo a otro");
                System.out.println("9. Camino mas corto de un nodo a otro");
                System.out.println("0. Salir");

                System.out.println("Introduzca una opcion: ");

                op = s.nextInt();

                switch (op){

                    case 1:{
                        System.out.println("Introduzca el Numero de Nodos");

                        int num = s.nextInt();
                        g.setNumNodos(num);
                        break;
                    }

                    case 2:{
                        g.agregarAristas();
                        System.out.println("Aristas Agregadas");
                        break;
                    }

                    case 3:{
                        g.imprimirMatriz();
                        break;
                    }

                    case 4:{
                        System.out.println("De que Nodo desea obtener el grado: ");
                        int grad= s.nextInt();
                        int ng=g.obtenerGrado(grad);
                        System.out.println("Grado del nodo " + grad +" es: " + ng);
                        break;
                    }

                    case 5:{
                        System.out.println("Para saber si hay adyacencia introduzca");
                        System.out.println("Nodo a: ");
                        int a =s.nextInt();
                        System.out.println("Nodo b:");
                        int b =s.nextInt();
                        if(g.verificarAdyacencia(a,b)){
                            System.out.println("Son Adyacentes");
                        }
                        else{
                            System.out.println("NO son Adyacentes");
                        }

                        break;
                    }

                    case 6:{
                        if(g.verificarGrafoConexo()){
                            System.out.println("El Grafo es CONEXO");
                        }
                        else{
                            System.out.println("El grafo NO es Conexo");
                        }
                        break;
                    }

                    case 7:{
                        if(g.verificarPesosPositivos()){
                            System.out.println("Todos los pesos SON POSITIVOS");
                        }
                        else{
                            System.out.println("Hay pesos negativos en el Grafo :c");
                        }
                        break;
                    }

                    case 8:{

                        System.out.println("Nodo inicial: ");
                        int i =s.nextInt();
                        System.out.println("Nodo final:");
                        int f =s.nextInt();


                        int l=g.dijkstra(i, f);

                        System.out.println("Distancia mas corta de i a f es: " + l);


                        break;
                    }

                    case 9:{

                        System.out.println("Nodo inicial: ");
                        int i =s.nextInt();
                        System.out.println("Nodo final:");
                        int f =s.nextInt();

                        int cr=g.caminoCorto(i, f);

                        System.out.println("Distancia mas corta de i a f es: " + cr);

                        break;
                    }

                    case 0:{
                        System.out.println("Gracias FIN del programa");
                        break;
                    }

                    default: {
                        System.out.println("Opcion no valida");
                    }



                }

            }while(op != 0);






        }



}
