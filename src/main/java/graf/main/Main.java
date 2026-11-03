package graf.main;

/* Realizado por: Michelle Ortiz Gil */
public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        // Insertar nodos
        Operaciones.insertarNodo(g, "A");
        Operaciones.insertarNodo(g, "B");
        Operaciones.insertarNodo(g, "C");
        Operaciones.insertarNodo(g, "D");

        // Insertar aristas
        Operaciones.insertarArista(g, "A", "B");
        Operaciones.insertarArista(g, "B", "C");
        Operaciones.insertarArista(g, "C", "D");
        Operaciones.insertarArista(g, "D", "A");

        // Listar
        Operaciones.listarGrafo(g);

        // Buscar
        Operaciones.buscarNodo(g, "B");
        Operaciones.buscarArista(g, "A", "C");

        // Actualizar (renombrar)
        Operaciones.actualizarNodo(g, "B", "B2");
        Operaciones.listarGrafo(g);

        // Eliminar arista y nodo
        Operaciones.eliminarArista(g, "A", "B2");
        Operaciones.eliminarNodo(g, "C");
        Operaciones.listarGrafo(g);
    }
}
