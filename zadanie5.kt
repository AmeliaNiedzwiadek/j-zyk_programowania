fun collatz(c0: Int): List<Int> {
    // To jest nasza funkcja. Nazywa się "collatz" i przyjmuje 1 liczbę: c0
    // Ta liczba musi być większa od zera (czyli naturalna)

    if (c0 <= 0) {
        // Sprawdzamy, czy użytkownik nie podał liczby mniejszej lub równej 0
        // Jeśli tak – zgłaszamy błąd
        throw IllegalArgumentException("c0 musi być większe od zera.")
        // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/
    }

    val wynik = mutableListOf<Int>()
    // Tworzymy pustą listę, do której będziemy zapisywać wszystkie liczby z ciągu
    // mutableListOf() = lista, którą można zmieniać (dodawać do niej elementy)
    // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-list-of/

    var c = c0
    // Tworzymy zmienną c, która będzie aktualną wartością ciągu
    // Zaczynamy od tej, którą podał użytkownik (czyli od c0)

    while (c != 1) {
        // Robimy pętlę dopóki c nie będzie równe 1

        wynik.add(c)
        // Dodajemy obecną wartość c do naszej listy wynikowej
        // Źródło: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/add/

        if (c % 2 == 0) {
            // Sprawdzamy, czy c jest parzyste (% 2 == 0 znaczy "dzieli się przez 2")
            c = c / 2
            // Jeśli tak – dzielimy przez 2
        } else {
            // Jeśli nie (czyli nieparzyste):
            c = 3 * c + 1
            // Wtedy mnożymy przez 3 i dodajemy 1
        }
    }

    wynik.add(1)
    // Na końcu dodajemy 1 do listy, bo to ostatnia liczba w ciągu przed cyklem

    return wynik
    // Zwracamy całą listę – to jest wynik funkcji
}

fun main() {
    val liczba = 7 // nasz początek ciągu

    val ciag = collatz(liczba)
    // Wywołujemy funkcję collatz i zapisujemy wynik do zmiennej "ciag"

    println("Ciąg Collatza dla $liczba:")
    println(ciag)
    // Wypisujemy całą listę
}


