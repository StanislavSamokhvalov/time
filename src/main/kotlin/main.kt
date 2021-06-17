val seconds = readLine()!!.toInt()
val minute = seconds / 60
val hour = seconds / (60 * 60)

fun endingMinutes(
    minute: Int
): String {
    return when (minute) {
        1, 21 -> "������"
        2 -> "������"
        else -> "�����"
    }
}

fun endingHours(
    hour: Int
): String {
    return when (hour) {
        1 -> "���"
        2, 3, 4 -> "����"
        else -> "�����"
    }
}

fun agoToText(
    seconds: Int
): String {
    return when (seconds) {
        in 0..60 -> "������ ���"
        in 60..(60 * 60) -> "$minute ${endingMinutes(minute)} �����"
        in 60 * 60 + 1..(60 * 60 * 24) -> "$hour ${endingHours(hour)} �����"
        in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> "�������"
        in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> "�����"
        else -> "�����"
    }
}

fun main() {
    val result = agoToText(seconds)
    print("���(�) � ���� $result")
}