fun podzbiory(x: List<Char>): List<List<Char>> {
    // Sprawdzenie, czy argument nie jest pusty
    // Dokumentacja: https://kotlinlang.org/docs/functions.html#require-check-and-assert
    require(x.isNotEmpty()) { "Lista nie może być pusta" }

    // Funkcja rekurencyjna do generowania podzbiorów, 
    fun generujPodzbiory(lista: List<Char>): List<List<Char>> {
        if (lista.isEmpty()) return listOf(emptyList())

        val pierwszy = lista.first() // Pobranie pierwszego elementu
        // Dokumentacja: https://kotlinlang.org/docs/collections-overview.html#retrieving-elements

        val reszta = generujPodzbiory(lista.drop(1)) // Rekurencyjne wywołanie dla reszty listy
        // Dokumentacja: https://kotlinlang.org/docs/collections-overview.html#retrieving-elements

        return reszta + reszta.map { it + pierwszy } // Dodanie pierwszego elementu do każdego podzbioru
        // Dokumentacja: https://kotlinlang.org/docs/collections-overview.html#transformations
    }

    return generujPodzbiory(x)
}

fun main() {
    println(podzbiory(listOf('a', 'b', 'c', 'd')))  // Przykład: powinno zwrócić wszystkie podzbiory
}


