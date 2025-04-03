fun wspolne(x: List<Int>, y: List<Int>): List<Int> {
    // Funkcja "wspolne" przyjmuje dwie listy liczb całkowitych: x i y
    // Zwraca listę z częścią wspólną (uwzględniając powtórzenia)

    val wynik = mutableListOf<Int>()
    // Tworzymy pustą listę, do której będziemy dodawać wspólne elementy
    // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-list-of/

    val yKopia = y.toMutableList()
    // Robimy kopię listy y, żeby móc usuwać z niej elementy (żeby nie liczyć ich kilka razy)
    // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-mutable-list/

    for (el in x) {
        // Dla każdego elementu el z listy x

        if (yKopia.contains(el)) {
            // Sprawdzamy, czy kopia listy y zawiera ten element
            // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/contains/

            wynik.add(el)
            // Jeśli tak, dodajemy go do listy wynik
            // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/add/

            yKopia.remove(el)
            // I usuwamy go z kopii listy y, żeby nie liczyć go ponownie
            // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/remove/
        }
    }

    return wynik
    // Zwracamy gotową listę wspólnych elementów
}
fun main() {
    val x = listOf(1, 9, 2, 3)
    val y = listOf(2, 2, 4)

    val czescWspolna = wspolne(x, y)

    println(czescWspolna)
}
