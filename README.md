# CI-3641-Kotlin-Herencia
Implementación de múltiples estructuras de datos en `Kotlin`. Se incluye un archivo 
`main.kt` que tiene unas demostraciones sencillas de estas estructuras implementadas.

### Estructuras implementadas
#### Secuencia
Se implementó una clase abstracta `Secuencia` que representa una colección ordenada 
de datos con los siguientes métodos:

- **agregar(obj):** Agrega un objeto a la colección.
- **remover():** Quita un elemento de la colección y lo devuelve.
- **vacio():** Indica si la colección está vacía.

Con esta clase abstracta se implementaron las siguientes colecciones:

- Pila
- Cola

Las implementaciones se encuentran en el archivo `Secuencia.kt`.

#### Grafo
Se implementó una clase `Grafo` para representar un grafo con listas de adyacencia 
y con identificación de vértices con un entero. Además, se implementó una clase abstracta `Busqueda` que define el siguiente método abstracto:

- **buscar(D, H):** Devuelve la cantidad de nodos explorados partiendo desde el
    nodo D hasta el nodo H. -1 Si no hay camino entre D y H.

De esta clase abstracta se derivan dos clases más:

- **BFS:** Realiza la búsqueda mediante BFS.
- **DFS:** Realiza la búsqueda mediante DFS.

Las implementaciones se encuentran en el archivo `Grafo.kt`

