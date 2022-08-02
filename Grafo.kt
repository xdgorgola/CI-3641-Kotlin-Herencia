import java.lang.Exception

/**
 * Clase que representa un grafo dirigido mediante listas de adyacencias.
 * Cada vertice del grafo es representado por un entero que se
 * le asigna al ser agregado.
 */
class Grafo {
    /** Listas de adyacencia */
    private val ady = mutableListOf<MutableList<Int>>()

    /** Numero de vertices en el grafo*/
    fun numeroVert(): Int = ady.size

    /** Agrega un vertice al grafo
     *
     * @return ID del vertice.
     */
    fun agregarVert(): Int {
        ady.add(mutableListOf<Int>())
        return numeroVert()
    }

    /** Agrega un arco entre dos vertices.
     *
     * @param f Vertice inicio del arco
     * @param t Vertice final del arco
     */
    fun agregarArco(f: Int, t: Int)
    {
        if (f >= ady.size || t >= ady.size)
            throw Exception("Vertices no existentes en el grafo")

        ady[f].add(t)
    }

    /** Retorna los vecinos de un vertice
     *
     * @param id ID del vertice a buscar vecinos
     *
     * @return Lista inmutable con los vecinos del vertice
     */
    fun vecinos(id: Int): List<Int>
    {
        if (id >= ady.size)
            throw Exception("Vertice no existente en el grafo")

        return ady[id].toList()
    }
}

/**
 * Clase encargada de realizar una busqueda sobre
 * un grafo.
 *
 * @param g Grafo objetivo
 */
abstract class Busqueda(val g: Grafo) {

    /** Realiza una busqueda desde un nodo D a un nodo H
     *
     * @param D Nodo de partida
     * @param H Nodo objetivo
     *
     * @return Cantidad de nodos explorados hasta H.
     * -1 si H no es alcanzable desde D.
     */
    abstract fun buscar(D: Int, H: Int): Int
}


/**
 * Implementacion de clase Busqueda que realiza su busqueda
 * mediante BFS.
 *
 * @param g Grafo objetivo
 */
class BFS(g: Grafo): Busqueda(g) {

    /**
     * Realiza una busqueda desde un nodo D a un nodo H
     * mediante BFS
     *
     * @param D Nodo de partida
     * @param H Nodo objetivo
     *
     * @return Cantidad de nodos explorados hasta H.
     * -1 si H no es alcanzable desde D.
     */
    override fun buscar(D: Int, H: Int): Int {
        var cuenta = 0
        val cola = Cola<Int>()
        val visitados = mutableSetOf<Int>()
        cola.agregar(D)

        while (!cola.vacio())
        {
            cuenta++
            val act = cola.remover()
            if (act == H)
                return cuenta

            val vec = g.vecinos(act)
            for (v in vec)
            {
                if (visitados.contains(v))
                    continue

                visitados.add(v)
                cola.agregar(v)
            }
        }

        return -1
    }
}


/**
 * Implementacion de clase Busqueda que realiza su busqueda
 * mediante DFS.
 *
 * @param g Grafo objetivo
 */
class DFS(g: Grafo): Busqueda(g)
{

    /**
     * Realiza una busqueda desde un nodo D a un nodo H
     * mediante DFS
     *
     * @param D Nodo de partida
     * @param H Nodo objetivo
     *
     * @return Cantidad de nodos explorados hasta H.
     * -1 si H no es alcanzable desde D.
     */
    override fun buscar(D: Int, H: Int): Int {
        var cuenta = 0
        val pila = Pila<Int>()
        val visitados = mutableSetOf<Int>()

        pila.agregar(D)
        while (!pila.vacio())
        {
            val act = pila.remover()
            if (visitados.contains(act))
                continue

            cuenta++
            if (act == H)
                return cuenta

            visitados.add(act)

            val vec = g.vecinos(act)
            for (v in vec)
            {
                if (visitados.contains(v))
                    continue

                pila.agregar(v)
            }
        }
        return -1
    }
}