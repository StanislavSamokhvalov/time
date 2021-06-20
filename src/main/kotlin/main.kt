import kotlin.math.roundToInt

fun secondsToMinutes(
    seconds: Int
): Int {
    return (seconds / 60).toDouble().roundToInt()
}

fun secondsToHours(
    seconds: Int
): Int {
    return (seconds / (60 * 60)).toDouble().roundToInt()
}


fun endingMinutes(
    seconds: Int
): String {
    return if (secondsToMinutes(seconds) % 10 == 1) "минуту"
    else if (secondsToMinutes(seconds) % 10 == 2 || secondsToMinutes(seconds) % 10 == 3 || secondsToMinutes(seconds) % 10 == 4) "минуты"
    else "минут"
}


fun endingHours(
    seconds: Int
): String {
    return when (secondsToHours(seconds)) {
        1 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
}

fun agoToText(
    seconds: Int
): String {
    return when (seconds) {
        in 0..60 -> "только что"
        in 60..(60 * 60) -> "${secondsToMinutes(seconds)} ${endingMinutes(seconds)} назад"
        in 60 * 60 + 1..(60 * 60 * 24) -> "${secondsToHours(seconds)} ${endingHours(seconds)} назад"
        in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> "сегодня"
        in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> "вчера"
        else -> "давно"
    }
}

fun main() {
    println("Введите количество секунд")
    val seconds = readLine()!!.toInt()
    val result = agoToText(seconds)
    print("был(а) в сети $result")
}

