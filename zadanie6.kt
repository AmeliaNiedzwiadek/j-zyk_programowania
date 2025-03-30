import java.util.Scanner // Importujemy Scanner do wczytywania danych
// https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html

fun main() {
    val scanner = Scanner(System.`in`) // Tworzymy obiekt Scanner
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/java.util.-scanner/

    print("Podaj sekwencję nici kodującej DNA (np. ATGCGT): ")
    val nicKodujaca = scanner.next().uppercase() // Wczytujemy wejście i konwertujemy do wielkich liter
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/uppercase.html

    try {
        val nicMatrycowa = komplement(nicKodujaca)
        println("Nić matrycowa DNA: $nicMatrycowa")

        val rna = transkrybuj(nicMatrycowa)
        println("Sekwencja RNA: $rna")
    } catch (e: IllegalArgumentException) {
        println("Błąd: ${e.message}") // Obsługa błędnych danych wejściowych
    }
}

// Funkcja zamieniająca nić kodującą DNA na nić matrycową (komplementarną)
fun komplement(sekwencja: String): String {
    require(sekwencja.all { it in "ATCG" }) { "Sekwencja DNA może zawierać tylko znaki: A, T, C, G" }
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/all.html

    val mapaKomplementarna = mapOf('A' to 'T', 'T' to 'A', 'C' to 'G', 'G' to 'C')
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map-of.html

    return sekwencja.map { mapaKomplementarna[it]!! }.joinToString("")
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map.html
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/join-to-string.html
}

// Funkcja transkrybująca nić matrycową DNA na RNA
fun transkrybuj(sekwencjaMatrycowa: String): String {
    require(sekwencjaMatrycowa.all { it in "ATCG" }) { "Sekwencja DNA może zawierać tylko znaki: A, T, C, G" }

    val mapaRNA = mapOf('A' to 'U', 'T' to 'A', 'C' to 'G', 'G' to 'C')

    return sekwencjaMatrycowa.map { mapaRNA[it]!! }.joinToString("")
}