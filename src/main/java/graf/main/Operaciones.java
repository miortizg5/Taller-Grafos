package graf.main;

/* Realizado por: Michelle Ortiz Gil */
public class Operaciones {

    // ---------- INSERTAR NODO ----------
    public static void insertarNodo(Grafo g, String nombre) {
        if (g.cantidad >= Grafo.MAX) {
            System.out.println("Error: grafo lleno.");
            return;
        }
        // Verificar si ya existe
        for (int i = 0; i < g.cantidad; i++) {
            if (g.nodos[i].equals(nombre)) {
                System.out.println("El nodo '" + nombre + "' ya existe.");
                return;
            }
        }
        g.nodos[g.cantidad] = nombre;
        g.cantidad++;
        System.out.println("Nodo '" + nombre + "' insertado.");
    }

    // ---------- INSERTAR ARISTA ----------
    public static void insertarArista(Grafo g, String origen, String destino) {
        int i = buscarIndice(g, origen);
        int j = buscarIndice(g, destino);

        if (i == -1 || j == -1) {
            System.out.println("Error: uno o ambos nodos no existen.");
            return;
        }
        g.matriz[i][j] = 1;
        g.matriz[j][i] = 1; // no dirigido
        System.out.println("Arista entre '" + origen + "' y '" + destino + "' insertada.");
    }

    // ---------- BUSCAR NODO ----------
    public static boolean buscarNodo(Grafo g, String nombre) {
        boolean existe = buscarIndice(g, nombre) != -1;
        System.out.println("¿Existe el nodo '" + nombre + "'? " + (existe ? "SÍ" : "NO"));
        return existe;
    }

    // ---------- BUSCAR ARISTA ----------
    public static boolean buscarArista(Grafo g, String origen, String destino) {
        int i = buscarIndice(g, origen);
        int j = buscarIndice(g, destino);

        if (i == -1 || j == -1) {
            System.out.println("Error: uno o ambos nodos no existen.");
            return false;
        }
        boolean existe = g.matriz[i][j] == 1;
        System.out.println("¿Existe arista entre '" + origen + "' y '" + destino + "'? "
                + (existe ? "SÍ" : "NO"));
        return existe;
    }

    // ---------- ACTUALIZAR NODO (renombrar) ----------
    public static void actualizarNodo(Grafo g, String viejo, String nuevo) {
        int i = buscarIndice(g, viejo);
        if (i == -1) {
            System.out.println("El nodo '" + viejo + "' no existe.");
            return;
        }
        if (buscarIndice(g, nuevo) != -1) {
            System.out.println("Ya existe un nodo llamado '" + nuevo + "'.");
            return;
        }
        g.nodos[i] = nuevo;
        System.out.println("Nodo '" + viejo + "' actualizado a '" + nuevo + "'.");
    }

    // ---------- ELIMINAR NODO ----------
    public static void eliminarNodo(Grafo g, String nombre) {
        int i = buscarIndice(g, nombre);
        if (i == -1) {
            System.out.println("El nodo '" + nombre + "' no existe.");
            return;
        }
        // Desplazar los nodos siguientes una posición a la izquierda
        for (int k = i; k < g.cantidad - 1; k++) {
            g.nodos[k] = g.nodos[k + 1];
        }
        g.nodos[g.cantidad - 1] = null;

        // Desplazar filas y columnas de la matriz
        for (int fila = i; fila < g.cantidad - 1; fila++) {
            for (int col = 0; col < g.cantidad; col++) {
                g.matriz[fila][col] = g.matriz[fila + 1][col];
            }
        }
        for (int fila = 0; fila < g.cantidad; fila++) {
            for (int col = i; col < g.cantidad - 1; col++) {
                g.matriz[fila][col] = g.matriz[fila][col + 1];
            }
        }
        g.cantidad--;
        System.out.println("Nodo '" + nombre + "' eliminado.");
    }

    // ---------- ELIMINAR ARISTA ----------
    public static void eliminarArista(Grafo g, String origen, String destino) {
        int i = buscarIndice(g, origen);
        int j = buscarIndice(g, destino);

        if (i == -1 || j == -1) {
            System.out.println("Error: uno o ambos nodos no existen.");
            return;
        }
        g.matriz[i][j] = 0;
        g.matriz[j][i] = 0;
        System.out.println("Arista entre '" + origen + "' y '" + destino + "' eliminada.");
    }

    // ---------- LISTAR GRAFO ----------
    public static void listarGrafo(Grafo g) {
        if (g.cantidad == 0) {
            System.out.println("El grafo está vacío.");
            return;
        }
        System.out.println("\n--- LISTADO DEL GRAFO ---");
        for (int i = 0; i < g.cantidad; i++) {
            System.out.print(g.nodos[i] + " -> ");
            boolean tieneVecinos = false;
            for (int j = 0; j < g.cantidad; j++) {
                if (g.matriz[i][j] == 1) {
                    System.out.print(g.nodos[j] + " ");
                    tieneVecinos = true;
                }
            }
            if (!tieneVecinos) System.out.print("(sin conexiones)");
            System.out.println();
        }
        System.out.println("-------------------------\n");
    }

    // ---------- LISTAR NODOS ----------
    public static void listarNodos(Grafo g) {
        System.out.print("Nodos: ");
        for (int i = 0; i < g.cantidad; i++) {
            System.out.print(g.nodos[i] + " ");
        }
        System.out.println();
    }

    // ---------- AUXILIAR: buscar índice de un nodo ----------
    // Devuelve la posición del nodo en el arreglo, o -1 si no existe
    public static int buscarIndice(Grafo g, String nombre) {
        for (int i = 0; i < g.cantidad; i++) {
            if (g.nodos[i].equals(nombre)) {
                return i;
            }
        }
        return -1;
    }
}
