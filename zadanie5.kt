import java.util.Scanner // Import klasy do wczytywania danych od użytkownika
// https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html

fun collatz(c0: Int): List<Int> {
    require(c0 > 0) { "Liczba początkowa musi być liczbą naturalną (większą od 0)." }
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/require.html

    val ciag = mutableListOf(c0) // Tworzymy listę do przechowywania kolejnych wartości
    var maxWartosc = c0
    var aktualna = c0

    while (aktualna != 1) { // Iterujemy dopóki ciąg nie wpada w cykl (4, 2, 1)
        aktualna = if (aktualna % 2 == 0) aktualna / 2 else 3 * aktualna + 1
        // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/if.html
        ciag.add(aktualna)
        if (aktualna > maxWartosc) maxWartosc = aktualna
    }

    return ciag
}

fun main() {
    val scanner = Scanner(System.`in`) // Tworzymy obiekt do odczytu danych
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/java.util.-scanner/

    print("Podaj wartość początkową c0: ")
    val c0 = scanner.nextInt() // Pobieramy liczbę od użytkownika

    try {
        val wynik = collatz(c0)
        val maxWartosc = wynik.maxOrNull() ?: c0 // Znajdujemy największy element
        val dlugosc = wynik.size // Długość ciągu

        println("Ciąg Collatza: $wynik")
        println("Maksymalna wartość w ciągu: $maxWartosc")
        println("Długość ciągu przed cyklem: ${dlugosc - 1}") // Odejmujemy ostatni element 1
    } catch (e: IllegalArgumentException) {
        println("Błąd: ${e.message}")
    }
}

