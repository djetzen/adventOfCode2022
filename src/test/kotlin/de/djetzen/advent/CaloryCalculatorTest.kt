package de.djetzen.advent

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CaloryCalculatorTest {

    @Test
    fun fileIsReadAndSplitAccordingly() {
        val caloryCalculator = CaloryCalculator()

        val caloryPerElve =
            caloryCalculator.readFileAndExtractCaloriesPerElve("src/test/resources/testInputs/testinput1_1.txt")

        assertEquals(4, caloryPerElve.size)
    }

    @Test
    fun elveWithMaximumCaloriesIsFound() {
        val caloryCalculator = CaloryCalculator()
        val fewCaloriesCarried = intArrayOf(1, 2, 3)
        val moreCaloriesCarried = intArrayOf(2, 3, 4)
        val mostCaloriesCarried = intArrayOf(3, 4, 5)

        val caloriesList = listOf(fewCaloriesCarried, moreCaloriesCarried, mostCaloriesCarried)

        val mostCaloryCountFound = caloryCalculator.getMostCaloriesPerElve(caloriesList)

        assertEquals(12, mostCaloryCountFound)
    }

    @Test
    fun findElveCarryingMostCalories() {
        val caloryCalculator = CaloryCalculator()
        val extractedCaloriesPerElve =
            caloryCalculator.readFileAndExtractCaloriesPerElve("src/test/resources/realInputs/realinput1_1.txt")

        val mostCaloriesPerElve = caloryCalculator.getMostCaloriesPerElve(extractedCaloriesPerElve)

        assertEquals(70764, mostCaloriesPerElve)
    }

    @Test
    fun findSumOfTopThreeElvesCarryingCalories() {
        val caloryCalculator = CaloryCalculator()

        val extractedCaloriesPerElve =
            caloryCalculator.readFileAndExtractCaloriesPerElve("src/test/resources/realInputs/realinput1_1.txt")

        val mostCaloriesPerElve = caloryCalculator.getSumOfCaloriesForTopThreeElves(extractedCaloriesPerElve)

        assertEquals(203905, mostCaloriesPerElve)
    }
}