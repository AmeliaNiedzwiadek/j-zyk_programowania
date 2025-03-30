fun heron(a: Double, b: Double, c: Double): Double {
    // Sprawdzenie, czy boki są dodatnie
    // Dokumentacja: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html
    require(a > 0 && b > 0 && c > 0) { "Boki muszą być dodatnie" }

    // Sprawdzenie warunku trójkąta
    // Dokumentacja: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html
    require(a + b > c && a + c > b && b + c > a) { "Podane długości boków nie tworzą trójkąta" }

    // Obliczenie półobwodu trójkąta
    val s = (a + b + c) / 2

    // W tej linijce obliczamy pole ze wzoru Herona
    // Dokumentacja: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/sqrt.html
    return kotlin.math.sqrt(s * (s - a) * (s - b) * (s - c))
}

fun main() {
    println(heron(3.0, 4.0, 6.0))  // W tym wierszu po wpisaniu dlugości boków uzyskujemy pole trójkąta ze wzoru Herona
}
