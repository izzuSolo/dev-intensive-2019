package ru.skillbranch.devintensive.extensions


import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs


const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) :Date{
    var time = this.time

    time += when(units){
        TimeUnits.SECOND-> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()):String{
    val timeDiff: Long = (date.time - this.time)
    var timeString: String = ""

    when(abs(timeDiff)){
        in(0 .. 1 * SECOND) -> timeString = "только что"

        in(1 * SECOND .. 45 * SECOND) -> if(abs(timeDiff) % 100 in(11..19)) timeString = if(timeDiff > 0)"${abs(timeDiff)} секунд назад" else "через ${abs(timeDiff)} секунд"
                                            else when((abs(timeDiff) % 10).toInt()){
                                                1 ->  timeString = if(timeDiff > 0)"$timeDiff секунду назад" else "через ${abs(timeDiff)} секунду"
                                                in(2..4) -> timeString = if(timeDiff > 0)"$timeDiff секунды назад" else "через ${abs(timeDiff)} секунды"
                                                else -> timeString = if(timeDiff > 0)"$timeDiff секунд назад" else "через ${abs(timeDiff)} секунд"
                                            }

        in(45 * SECOND .. 75 * SECOND) -> timeString = if(timeDiff > 0) "минуту назад" else "через минуту"

        in(75 * SECOND .. 45 * MINUTE) -> if(abs(timeDiff)/ MINUTE in(11..19)) timeString = if(timeDiff > 0)"${abs(timeDiff)/ MINUTE} минут назад" else "через ${abs(timeDiff)/ MINUTE} минут"
                                                else when(((abs(timeDiff)/ MINUTE) % 10).toInt()){
                                                    1 ->  timeString = if(timeDiff > 0)"${abs(timeDiff)/ MINUTE} минуту назад" else "через ${abs(timeDiff)/ MINUTE} минуту"
                                                    in(2..4) -> timeString = if(timeDiff > 0)"${abs(timeDiff)/ MINUTE} минуты назад" else "через ${abs(timeDiff)/ MINUTE} минуты"
                                                    else -> timeString = if(timeDiff > 0)"${abs(timeDiff)/ MINUTE} минут назад" else "через ${abs(timeDiff)/ MINUTE} минут"
                                                }

        in(45 * MINUTE .. 75 * MINUTE) -> timeString = if(timeDiff > 0) "час назад" else "через час"

        in(75 * MINUTE .. 22 * HOUR) -> if(abs(timeDiff)/ HOUR in(11..19)) timeString = if(timeDiff > 0)"${abs(timeDiff)/ HOUR} часов назад" else "через ${abs(timeDiff)/ HOUR} часов"
                                                else when(((abs(timeDiff)/ HOUR) % 10).toInt()){
                                                    1 ->  timeString = if(timeDiff > 0)"${abs(timeDiff)/ HOUR} час назад" else "через ${abs(timeDiff)/ HOUR} час"
                                                    in(2..4) -> timeString = if(timeDiff > 0)"${abs(timeDiff)/ HOUR} часа назад" else "через ${abs(timeDiff)/ HOUR} часа"
                                                    else -> timeString = if(timeDiff > 0)"${abs(timeDiff)/ HOUR} часов назад" else "через ${abs(timeDiff)/ HOUR} часов"
                                                }
        in(22 * HOUR .. 26 * HOUR) -> timeString = if(timeDiff > 0) "день назад" else "через день"

        in(26 * HOUR .. 360 * DAY) -> if((abs(timeDiff)/ DAY) % 100 in(11..19)) timeString = if(timeDiff > 0)"${abs(timeDiff)/ DAY} дней назад" else "через ${abs(timeDiff)/ DAY} дней"
                                            else when(((abs(timeDiff)/ DAY) % 10).toInt()){
                                                    1 ->  timeString = if(timeDiff > 0)"${abs(timeDiff)/ MINUTE} минуту назад" else "через ${abs(timeDiff)/ MINUTE} минуту"
                                                    in(2..4) -> timeString = if(timeDiff > 0)"${abs(timeDiff)/ MINUTE} минуты назад" else "через ${abs(timeDiff)/ MINUTE} минуты"
                                                    else -> timeString = if(timeDiff > 0)"${abs(timeDiff)/ MINUTE} минут назад" else "через ${abs(timeDiff)/ MINUTE} минут"
                                            }
        else -> timeString = if(timeDiff > 0) "более года назад" else "через более года"
    }
    return timeString
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}