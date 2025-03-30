fun wspolne(x: List<Int>, y: List<Int>): List<Int> {
    // Sprawdzamy, czy argumenty nie są puste
    // Dokumentacja: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html
    require(x.isNotEmpty() && y.isNotEmpty()) { "Listy nie mogą być puste" }

    // Obliczamy części wspólne multizbiorów
    // Dokumentacja: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/filter.html
    return x.filter { it in y }
}

fun main() {
    println(wspolne(listOf(1, 2, 1, 3), listOf(2, 3, 4)))
}
