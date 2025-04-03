fun podzbiory(x: List<String>): List<List<String>> {
    if (x.isEmpty()) {
        throw IllegalArgumentException("Lista nie może być pusta.")
        // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/
    }

    val wynik = mutableListOf<List<String>>()
    // Pusta lista, do której będziemy dodawać wszystkie podzbiory
    // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-list-of/

    wynik.add(listOf())
    // Dodajemy pusty podzbiór jako pierwszy
    // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/list-of/

    for (element in x) {
        val nowePodzbiory = mutableListOf<List<String>>()
        // Lista tymczasowa do przechowywania nowych podzbiorów z aktualnym elementem

        for (istniejacy in wynik) {
            val nowy = istniejacy + element
            // Tworzymy nowy podzbiór: istniejący + nowy element
            nowePodzbiory.add(nowy)
        }

        wynik.addAll(nowePodzbiory)
        // Dodajemy wszystkie nowe podzbiory do wyniku
        // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-collection/add-all/
    }

    return wynik
}
fun main() {
    val zbior = listOf("a", "b", "c", "d", "e")  // nasz zbiór wejściowy
    val podzbioryList = podzbiory(zbior) // wywołujemy funkcję

    for (podzbior in podzbioryList) {
        println(podzbior) // wypisujemy każdy podzbiór
    }
}



