package ru.skillbranch.devintensive.extensions

fun String.truncate(value: Int = 16):String{
    if(value < 0) return this
    var truncateString = dropLast(length - value).trimEnd()
    if (this.trimEnd() != truncateString)
        truncateString += "..."

    return truncateString
}
