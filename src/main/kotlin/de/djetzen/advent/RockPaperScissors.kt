package de.djetzen.advent

import java.nio.file.Files
import java.nio.file.Paths

class RockPaperScissors {
    fun parse(fileName: String): List<StrategyElement> {
        val allLines = Files.readAllLines(Paths.get(fileName))
        var strategyElements = ArrayList<StrategyElement>()
        for (line in allLines) {
            val strategyElement = StrategyElement(convertInput(line.filterNot { it.isWhitespace() }[0]),
                convertResponse(line.filterNot { it.isWhitespace() }[1])
            )
            strategyElements += strategyElement
        }
        return strategyElements
    }

    fun getScore(strategyElement: StrategyElement): Int {
        var score = getValuePlayed(strategyElement.response)

        if (isDraw(strategyElement)) {
            score += 3
        }
        if (isWin(strategyElement)) {
            score += 6
        }

        return score
    }

    private fun isDraw(strategyElement: StrategyElement): Boolean {
        return strategyElement.input == strategyElement.response
    }

    data class StrategyElement(val input: Play, val response: Play)

    enum class Play {
        ROCK,
        PAPER,
        SCISSORS
    }

    private fun getValuePlayed(play: Play): Int {
        if (play == Play.ROCK) {
            return 1
        } else if (play == Play.PAPER) {
            return 2
        } else {
            return 3
        }
    }

    private fun isWin(strategyElement: StrategyElement): Boolean {
        if (strategyElement.input == Play.ROCK && strategyElement.response == Play.PAPER) {
            return true
        } else if (strategyElement.input == Play.PAPER && strategyElement.response == Play.SCISSORS) {
            return true
        } else return strategyElement.input == Play.SCISSORS && strategyElement.response == Play.ROCK
    }

    private fun convertInput(input: Char): Play {
        return when (input) {
            'A' -> {
                Play.ROCK
            }

            'B' -> {
                Play.PAPER
            }

            else -> {
                Play.SCISSORS
            }
        }
    }

    private fun convertResponse(input: Char): Play {
        return when (input) {
            'X' -> {
                Play.ROCK
            }

            'Y' -> {
                Play.PAPER
            }

            else -> {
                Play.SCISSORS
            }
        }
    }

}
