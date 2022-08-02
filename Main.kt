fun main() {
    // Sencilla demostracion de las secuencias
    val cola = Cola<Int>()
    val pila = Pila<Int>()

    for (i in 0..2) {
        cola.agregar(i)
        pila.agregar(i)
    }

    for (i in 0..2) {
        println("Cola dequeue ${cola.remover()}")
        println("Pila pop ${pila.remover()}")
    }

    // Sencilla demostracion de las busquedas
    val grafo = Grafo()
    for (i in 0..7)
        grafo.agregarVert()

    grafo.agregarArco(0, 1)
    grafo.agregarArco(0, 2)
    grafo.agregarArco(1, 3)
    grafo.agregarArco(1, 4)
    grafo.agregarArco(2, 5)
    grafo.agregarArco(2, 6)

    val bfs = BFS(grafo)
    val dfs = DFS(grafo)

    println("Vertices explorados BFS de 0 a 6: ${bfs.buscar(0, 6)}")
    println("Vertices explorados DFS de 0 a 3: ${dfs.buscar(0, 3)}")

    println("Vertices explorados BFS de 0 a 7: ${bfs.buscar(0, 7)}")
    println("Vertices explorados DFS de 0 a 7: ${dfs.buscar(0, 7)}")
}

