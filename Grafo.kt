import java.lang.Exception

class Grafo {
    private var ady = mutableListOf<MutableList<Int>>()

    fun numeroVert(): Int = ady.size
    fun agregarVert() = ady.add(mutableListOf<Int>())
    fun agregarArco(f: Int, t: Int)
    {
        if (f >= ady.size || t >= ady.size)
            throw Exception("Vertices no existentes en el grafo")

        ady[f].add(t)
    }

    fun vecinos(id: Int): List<Int>
    {
        if (id >= ady.size)
            throw Exception("Vertice no existente en el grafo")

        return ady[id].toList()
    }
}

abstract class Busqueda(val g: Grafo) {
    abstract fun buscar(D: Int, H: Int): Int
}

class BFS(g: Grafo): Busqueda(g) {

    override fun buscar(D: Int, H: Int): Int {
        var cuenta = 0
        var cola = Cola<Int>()
        var visitados = mutableSetOf<Int>()

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


class DFS(g: Grafo): Busqueda(g)
{
    override fun buscar(D: Int, H: Int): Int {
        var cuenta = 0
        var pila = Pila<Int>()
        var visitados = mutableSetOf<Int>()

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