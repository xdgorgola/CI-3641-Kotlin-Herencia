/** Clase que representa una secuencia de objetos sencilla */
abstract class Secuencia<T> {

    protected val contenedor = mutableListOf<T>();

    /** Agrega un objeto a la secuencia
     *
     * @param obj Objeto a agregar
     */
    abstract fun agregar(obj: T)

    /** Quita un objeto de la secuencia
     *
     * @return Objeto removido de la secuencia
     */
    abstract fun remover() : T

    /** Indica si la secuencia esta vacia
     *
     * @return true en caso de estar vacia la secuencia.
     * false en caso contrario.
     */
    fun vacio() : Boolean = (contenedor.size == 0)
}

/**
 * Secuencia que realiza las operaciones agregar y remover
 * siguiendo una politica LI-FO (Last in - First out)
 */
class Pila<T>: Secuencia<T>()
{
    override fun agregar(obj: T) {
        contenedor.add(obj)
    }

    override fun remover(): T {
        if (vacio())
            throw Exception("La pila no tiene elementos")

        return contenedor.removeLast()
    }
}

/**
 * Secuencia que realiza las operaciones agregar y remover
 * siguiendo una politica FI-FO (First in - First out)
 */
class Cola<T>: Secuencia<T>()
{
    override fun agregar(obj: T) {
        contenedor.add(obj)
    }

    override fun remover(): T {
        if (vacio())
            throw Exception("La cola no tiene elementos")

        return contenedor.removeFirst()
    }
}