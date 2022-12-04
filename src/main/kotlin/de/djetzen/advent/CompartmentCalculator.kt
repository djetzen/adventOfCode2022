package de.djetzen.advent

import java.nio.file.Files
import java.nio.file.Paths

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

    fun parseForSingleCompartment(fileName: String): List<String> {
        return Files.readAllLines(Paths.get(fileName))
    }

    fun findCommonPartsForGroup(first: String, second: String, third: String): String {
        val elementsInFirst = first.map { c -> c }
        val elementsInFirstAndSecond = ArrayList<Char>()
        second.forEach { c ->
            if (elementsInFirst.contains(c)) {
                elementsInFirstAndSecond += c
            }
        }
        third.forEach { c ->
            if (elementsInFirstAndSecond.contains(c)) {
                return c.toString()
            }
        }
        return ""
    }

}
