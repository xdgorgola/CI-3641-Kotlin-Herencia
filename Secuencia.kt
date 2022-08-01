abstract class Secuencia<T> {

    protected var _contenedor = mutableListOf<T>();
    abstract fun agregar(obj: T)
    abstract fun remover() : T

    fun vacio() : Boolean = (_contenedor.size == 0)
}

class Pila<T>: Secuencia<T>()
{
    override fun agregar(obj: T) {
        _contenedor.add(obj)
    }

    override fun remover(): T {
        if (vacio())
            throw Exception("La pila no tiene elementos")

        return _contenedor.removeLast()
    }
}

class Cola<T>: Secuencia<T>()
{
    override fun agregar(obj: T) {
        _contenedor.add(obj)
    }

    override fun remover(): T {
        if (vacio())
            throw Exception("La cola no tiene elementos")

        return _contenedor.removeFirst()
    }
}