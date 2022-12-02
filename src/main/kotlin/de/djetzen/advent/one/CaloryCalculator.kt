package de.djetzen.advent.one

import java.nio.file.Files
import java.nio.file.Paths

class CaloryCalculator {

    fun readFileAndExtractCaloriesPerElve(fileName: String): List<IntArray> {
        val readAllLines = Files.readAllLines(Paths.get(fileName))

        val caloriesList = ArrayList<IntArray>()

        var caloryPerElve = intArrayOf()
        for (line in readAllLines) {
            if(line.isBlank() || readAllLines.last()==line) {
                caloriesList+=caloryPerElve
                caloryPerElve = intArrayOf()
            }
            else {
                caloryPerElve+=Integer.parseInt(line!!)
            }
        }
        return caloriesList

    }

    fun getMostCaloriesPerElve(caloriesList: List<IntArray>): Int? {
        return caloriesList.maxOfOrNull { it.sum() }
    }

    fun getSumOfCaloriesForTopThreeElves(caloriesList: List<IntArray>): Int {
        return caloriesList.map{it.sum()}.sortedDescending().take(3).sum()
    }

}