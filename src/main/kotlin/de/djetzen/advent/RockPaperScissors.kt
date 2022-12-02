package de.djetzen.advent

import java.nio.file.Files
import java.nio.file.Paths

class RockPaperScissors {
    data class StrategyElement(val input: Play, val response: Play)
    data class RealStrategy(val input: Play, val response: Char)

    enum class Play {
        ROCK,
        PAPER,
        SCISSORS
    }

    fun parseToStrategyElement(fileName: String): List<StrategyElement> {
        val allLines = Files.readAllLines(Paths.get(fileName))
        val strategyElements = ArrayList<StrategyElement>()
        for (line in allLines) {
            val strategyElement = StrategyElement(
                convertInput(line.filterNot { it.isWhitespace() }[0]),
                convertResponse(line.filterNot { it.isWhitespace() }[1])
            )
            strategyElements += strategyElement
        }
        return strategyElements
    }

    fun parseToRealStrategy(fileName: String): List<RealStrategy> {
        val allLines = Files.readAllLines(Paths.get(fileName))
        val strategyElements = ArrayList<RealStrategy>()
        for (line in allLines) {
            val strategyElement = RealStrategy(
                convertInput(line.filterNot { it.isWhitespace() }[0]),
                line.filterNot { it.isWhitespace() }[1]
            )
            strategyElements += strategyElement
        }
        return strategyElements
    }


    fun getScoreRegardingAssumption(strategyElement: StrategyElement): Int {
        var score = getValuePlayed(strategyElement.response)

        if (isDraw(strategyElement)) {
            score += 3
        }
        if (isWin(strategyElement)) {
            score += 6
        }

        return score
    }

    fun getScoreRegardingRealRules(play: Play, char: Char): Int {
        var score = 0
        score += getScoreForRealRules(char)
        when (char) {
            'X' -> {
                score += getLosingValue(play)
            }

            'Y' -> {
                score += getValuePlayed(play)
            }

            else -> {
                score += getWinningValue(play)
            }
        }
        return score
    }

    private fun isDraw(strategyElement: StrategyElement): Boolean {
        return strategyElement.input == strategyElement.response
    }

    private fun getValuePlayed(play: Play): Int {
        return when (play) {
            Play.ROCK -> {
                1
            }

            Play.PAPER -> {
                2
            }

            else -> {
                3
            }
        }
    }

    private fun getLosingValue(play: Play): Int {
        return when (play) {
            Play.ROCK -> {
                3
            }

            Play.PAPER -> {
                1
            }

            else -> {
                2
            }
        }
    }

    private fun getWinningValue(play: Play): Int {
        return when (play) {
            Play.ROCK -> {
                2
            }

            Play.PAPER -> {
                3
            }

            else -> {
                1
            }
        }
    }

    private fun isWin(strategyElement: StrategyElement): Boolean {
        return if (strategyElement.input == Play.ROCK && strategyElement.response == Play.PAPER) {
            true
        } else if (strategyElement.input == Play.PAPER && strategyElement.response == Play.SCISSORS) {
            true
        } else strategyElement.input == Play.SCISSORS && strategyElement.response == Play.ROCK
    }

    private fun getScoreForRealRules(input: Char): Int {
        return when (input) {
            'X' -> {
                0
            }

            'Y' -> {
                3
            }

            else -> {
                6
            }
        }
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
