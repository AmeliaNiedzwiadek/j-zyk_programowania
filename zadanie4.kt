fun fibonacciIteracyjnie(n: Int): List<Int> {
    require(n >= 0) { "Liczba n musi być nieujemna" } // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html

    if (n == 0) return emptyList() // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/empty-list.html
    if (n == 1) return listOf(0) // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/list-of.html

    val fibList = mutableListOf(0, 1) // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-list-of.html
    for (i in 2 until n) { // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/until.html
        fibList.add(fibList[i - 1] + fibList[i - 2]) // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/add.html
    }
    return fibList
}

fun fibonacciRekurencyjnie(n: Int, a: Int = 0, b: Int = 1, lista: MutableList<Int> = mutableListOf()): List<Int> {
    require(n >= 0) { "Liczba n musi być nieujemna" } // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html

    if (lista.size == n) return lista.toList() // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-list.html
    lista.add(a) // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/add.html
    return fibonacciRekurencyjnie(n, b, a + b, lista)
}

fun main() {
    val n = 10

    println("Iteracyjnie: ${fibonacciIteracyjnie(n)}")
    println("Rekurencyjnie: ${fibonacciRekurencyjnie(n)}")
}

