import kotlin.random.Random

fun main() {
    return startGame()
}

fun startGame(){
    val digits = ('0'..'9').shuffled(Random)
    val secretNumber = digits.subList(0, 4).joinToString("")
    println(secretNumber)
    var attempts = 1

    while (true) {
        print("Введите 4-значное число: ")
        val guess = readln()

        val (bulls, cows) = tryGuess(guess, secretNumber)
        println("Результат попытки $attempts: \n\tКоличество быков: $bulls \n\tКоличество коров: $cows\n")

        if (bulls == 4) {
            println("Победа! \nВы отгадали число $secretNumber \nКоличество попыток: $attempts")
            return
        }
        attempts++
    }
}

fun tryGuess(suggestedNumber: String, secretNumber: String): Pair<Int, Int> {
    var bulls = 0
    var cows = 0

    for (i in suggestedNumber.indices) {
        if (suggestedNumber[i] == secretNumber[i]) {
            bulls++
        } else if (secretNumber.contains(suggestedNumber[i])) {
            cows++
        }
    }

    return Pair(bulls, cows)
}