val seconds = readLine()!!.toInt()
val minute = seconds / 60
val hour = seconds / (60 * 60)

fun endingMinutes(
    minute: Int
): String {
    return when (minute) {
        1, 21 -> "минуту"
        2 -> "минуты"
        else -> "минут"
    }
}

fun endingHours(
    hour: Int
): String {
    return when (hour) {
        1 -> "час"
        2, 3, 4 -> "часа"
        else -> "часов"
    }
}

fun agoToText(
    seconds: Int
): String {
    return when (seconds) {
        in 0..60 -> "только что"
        in 60..(60 * 60) -> "$minute ${endingMinutes(minute)} назад"
        in 60 * 60 + 1..(60 * 60 * 24) -> "$hour ${endingHours(hour)} назад"
        in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> "сегодня"
        in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> "вчера"
        else -> "давно"
    }
}

fun main() {
    val result = agoToText(seconds)
    print("был(а) в сети $result")
}