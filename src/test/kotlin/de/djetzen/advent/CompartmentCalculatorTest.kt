package de.djetzen.advent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths

class CompartmentCalculatorTest {

    @Test
    fun stringIsSplittedInHalves() {
        val calc = CompartmentCalculator()
        val parts = calc.split("abcd")

        assertEquals(2, parts.size)
        assertEquals("ab", parts.first())
        assertEquals("cd", parts.last())
    }

    @Test
    fun commonLettersAreFound() {
        val calc = CompartmentCalculator()

        val commonLetter = calc.findCommonParts("ab", "ac")

        assertEquals("a", commonLetter)
    }

    @Test
    fun ifNoCommonLetterIsFoundTheResultIsEmpty() {
        val calc = CompartmentCalculator()

        val commonLetter = calc.findCommonParts("ab", "ec")

        assertEquals("", commonLetter)
    }

    @Test
    fun priorityOfLowerLettersAre1To26() {
        val calc = CompartmentCalculator()

        val prioOfA = calc.getPriority('a')
        val prioOfZ = calc.getPriority('z')

        assertEquals(1, prioOfA)
        assertEquals(26, prioOfZ)
    }


    @Test
    fun priorityOfUpperLettersAre27To52() {
        val calc = CompartmentCalculator()

        val prioOfA = calc.getPriority('A')
        val prioOfZ = calc.getPriority('Z')

        assertEquals(27, prioOfA)
        assertEquals(52, prioOfZ)
    }

    @Test
    fun getSolutionForFirstDay() {
        val calc = CompartmentCalculator()

        val allLines = Files.readAllLines(Paths.get("src/test/resources/realInputs/realinput3_1.txt"))

        var prioritySum = 0
        for (line in allLines) {
            val split = calc.split(line)
            val commonLetter = calc.findCommonParts(split.first(), split.last())
            val priority = calc.getPriority(commonLetter[0])
            prioritySum += priority
        }

        assertEquals(7908, prioritySum)
    }
}