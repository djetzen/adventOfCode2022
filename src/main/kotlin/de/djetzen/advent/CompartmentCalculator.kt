package de.djetzen.advent

class CompartmentCalculator {
    fun split(s: String): List<String> {
        return listOf(s.substring(0, s.length / 2), s.substring(s.length / 2))
    }

    fun findCommonParts(first: String, second: String): String {
        val elements = first.map { c -> c }
        second.forEach { c ->
            if (elements.contains(c)) {
                return c.toString()
            }
        }
        return ""
    }

    fun getPriority(c: Char): Int {
        return if (c.isLowerCase()) {
            c.code - 96
        } else {
            c.code - 38
        }
    }

}
