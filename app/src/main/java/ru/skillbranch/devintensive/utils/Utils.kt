package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName : String?) : Pair<String?, String?> {
        val parts : List<String>? =if(fullName?.split(" ")?.get(0) == "") null else fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return firstName to lastName
    }
    fun transliteration(payload: String, divider: String = " "): String{
        return payload
    }

    fun toInitials(firstName: String?, lastName: String?): String?{
        val firstChar: String = firstName?.capitalize()?.getOrNull(0).toString()
        val lastChar: String = lastName?.capitalize()?.getOrNull(0)?.toString()?:""
        return "${if(firstChar.plus(lastChar).isBlank()) null else firstChar.plus(lastChar)}"
    }
}