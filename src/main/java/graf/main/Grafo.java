package graf.main;

/* Realizado por: Michelle Ortiz Gil */
public class Grafo {
    // Máximo de nodos que puede tener el grafo
    public static final int MAX = 20;

    // Nombres de los nodos
    public String[] nodos;

    // Matriz de adyacencia: 1 = hay arista, 0 = no hay
    public int[][] matriz;

    // Cuántos nodos hay actualmente
    public int cantidad;

    public Grafo() {
        nodos = new String[MAX];
        matriz = new int[MAX][MAX];
        cantidad = 0;
    }
}
