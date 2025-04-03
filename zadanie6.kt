// FUNKCJA: komplement
// Tworzy nić matrycową na podstawie nici kodującej DNA (A ↔ T, C ↔ G)
fun komplement(dna: String): String {
    var wynik = ""  // Pusta zmienna typu String do przechowywania wyniku
    // Dokumentacja String: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/

    for (znak in dna) {  // Pętla po każdym znaku w DNA
        // Dokumentacja for: https://kotlinlang.org/docs/control-flow.html#for-loops

        if (znak == 'A') wynik += 'T'         // A → T
        else if (znak == 'T') wynik += 'A'    // T → A
        else if (znak == 'C') wynik += 'G'    // C → G
        else if (znak == 'G') wynik += 'C'    // G → C
        else throw IllegalArgumentException("Nieprawidłowy znak: $znak")
        // Dokumentacja wyjątku: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/
    }

    return wynik  // Zwracamy wynik
}

// FUNKCJA: transkrybuj
// Tworzy sekwencję RNA na podstawie nici matrycowej DNA
fun transkrybuj(dna: String): String {
    var wynik = ""  // Tworzymy pusty łańcuch RNA
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/

    for (znak in dna) {
        if (znak == 'A') wynik += 'U'         // A → U
        else if (znak == 'T') wynik += 'A'    // T → A
        else if (znak == 'C') wynik += 'G'    // C → G
        else if (znak == 'G') wynik += 'C'    // G → C
        else throw IllegalArgumentException("Nieprawidłowy znak: $znak")
        // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/
    }

    return wynik
}

// Funkcja transluj przyjmuje sekwencję RNA jako tekst (String)
// Dzieli ją na trójki (kodony) i zamienia je na aminokwasy
// Translacja zaczyna się od kodonu START (AUG) i kończy na kodonie STOP (UAA, UAG, UGA)
fun transluj(rna: String): String {
    var wynik = ""    // Tworzymy pusty tekst – tu zapiszemy aminokwasy
    // Dokumentacja String: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/

    var start = false // Zmienna logiczna – czy znaleźliśmy kodon START?
    // Dokumentacja Boolean: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/

    var i = 0         // Zmienna do śledzenia pozycji w RNA
    // Dokumentacja Int: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/

    while (i + 2 < rna.length) {
        // Pętla while działa dopóki możemy wyciągnąć 3 znaki (kodon)
        // Dokumentacja while: https://kotlinlang.org/docs/control-flow.html#while-loops

        val kodon = rna.substring(i, i + 3)
        // substring() wycina fragment tekstu (od pozycji i do i+2)
        // Dokumentacja: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/substring/

        if (kodon == "AUG") {
            if (wynik != "") wynik += " "  // dodajemy spację, jeśli to nie pierwszy aminokwas
            wynik += "Met"                 // Metionina – kodon START
            start = true                   // ustawiamy, że translacja się rozpoczęła

        } else if (start) {  // Jeśli już rozpoczęliśmy translację (czyli był kodon START)

            if (kodon == "UAA" || kodon == "UAG" || kodon == "UGA") {
                break  // Jeśli trafimy na kodon STOP – kończymy translację
            } else {
                if (wynik != "") wynik += " "  // dodajemy spację między aminokwasami

                if (kodon == "UUU" || kodon == "UUC") wynik += "Phe"  // Fenyloalanina
                else if (kodon == "GAA" || kodon == "GAG") wynik += "Glu"  // Glutaminowy
                else wynik += "???"  // Jeśli kodon nieznany – wpisujemy ??? jako symbol nieznanego aminokwasu
            }
        }

        i += 3  // Przechodzimy do kolejnego kodonu (czyli +3 litery w RNA)
    }

    // Jeśli translacja została rozpoczęta (był kodon START), to zwracamy sekwencję białka
    // W przeciwnym razie – informujemy użytkownika
    return if (start) wynik else "Brak kodonu start (AUG) – translacja niemożliwa"
    // Dokumentacja operatora if/else: https://kotlinlang.org/docs/control-flow.html#if-expression
}

// FUNKCJA: main
// Prosi użytkownika o dane wejściowe i przetwarza sekwencję genetyczną
fun main() {
    println("Podaj nić kodującą DNA (użyj tylko A, T, C, G):")  // Komunikat dla użytkownika

    val kodujaca = readLine()?.uppercase() ?: ""
    // Pobieramy dane od użytkownika i zamieniamy na wielkie litery
    // Dokumentacja readLine: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/read-line/
    // Dokumentacja uppercase: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/uppercase/

    if (kodujaca.isEmpty()) {
        println("Nie podano żadnej sekwencji.")
        return  // Kończymy program, jeśli użytkownik nic nie wpisał
    }

    val matrycowa = komplement(kodujaca)  // Tworzymy nić matrycową
    println("Nić matrycowa DNA:     $matrycowa")

    val rna = transkrybuj(matrycowa)  // Tworzymy RNA
    println("Sekwencja RNA:         $rna")

    val bialko = transluj(rna)  // Tworzymy białko z RNA
    println("Sekwencja białka:      $bialko")
}
