package de.djetzen.advent

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class RockPaperScissorsTest {

    @Test
    fun inputIsParseForAssumedRoles() {
        val rps = RockPaperScissors()
        val parsedStrategies = rps.parseToStrategyElement("src/test/resources/testInputs/testinput2_1.txt")

        val expectedStrategies = listOf(
            RockPaperScissors.StrategyElement(RockPaperScissors.Play.ROCK, RockPaperScissors.Play.ROCK),
            RockPaperScissors.StrategyElement(RockPaperScissors.Play.PAPER, RockPaperScissors.Play.PAPER),
            RockPaperScissors.StrategyElement(RockPaperScissors.Play.SCISSORS, RockPaperScissors.Play.SCISSORS)
        )

        assertEquals(expectedStrategies, parsedStrategies)
    }

    @Test
    fun playingRockIsScoreOne() {
        val rps = RockPaperScissors()

        val score =
            rps.getScoreRegardingAssumption(
                RockPaperScissors.StrategyElement(
                    RockPaperScissors.Play.ROCK,
                    RockPaperScissors.Play.ROCK
                )
            )

        assertEquals(4, score)
    }

    @Test
    fun playingPaperIsScoreTwo() {
        val rps = RockPaperScissors()

        val score =
            rps.getScoreRegardingAssumption(
                RockPaperScissors.StrategyElement(
                    RockPaperScissors.Play.PAPER,
                    RockPaperScissors.Play.PAPER
                )
            )

        assertEquals(5, score)
    }

    @Test
    fun playingScissorsIsScoreThree() {
        val rps = RockPaperScissors()

        val score =
            rps.getScoreRegardingAssumption(
                RockPaperScissors.StrategyElement(
                    RockPaperScissors.Play.SCISSORS,
                    RockPaperScissors.Play.SCISSORS
                )
            )

        assertEquals(6, score)
    }

    @Test
    fun losingIsOnlyScoreOfPlayed() {
        val rps = RockPaperScissors()

        val score =
            rps.getScoreRegardingAssumption(
                RockPaperScissors.StrategyElement(
                    RockPaperScissors.Play.PAPER,
                    RockPaperScissors.Play.ROCK
                )
            )

        assertEquals(1, score)
    }

    @Test
    fun drawIsScoreOfThreePlusPlayed() {
        val rps = RockPaperScissors()

        val score =
            rps.getScoreRegardingAssumption(
                RockPaperScissors.StrategyElement(
                    RockPaperScissors.Play.ROCK,
                    RockPaperScissors.Play.ROCK
                )
            )

        assertEquals(4, score)
    }


    @Test
    fun scissorWinsAgainstPaper() {
        val rps = RockPaperScissors()

        val score =
            rps.getScoreRegardingAssumption(
                RockPaperScissors.StrategyElement(
                    RockPaperScissors.Play.PAPER,
                    RockPaperScissors.Play.SCISSORS
                )
            )

        assertEquals(9, score)
    }

    @Test
    fun paperWinsAgainstRock() {
        val rps = RockPaperScissors()

        val score =
            rps.getScoreRegardingAssumption(
                RockPaperScissors.StrategyElement(
                    RockPaperScissors.Play.ROCK,
                    RockPaperScissors.Play.PAPER
                )
            )

        assertEquals(8, score)
    }

    @Test
    fun rockWinsAgainstScissors() {
        val rps = RockPaperScissors()

        val score =
            rps.getScoreRegardingAssumption(
                RockPaperScissors.StrategyElement(
                    RockPaperScissors.Play.SCISSORS,
                    RockPaperScissors.Play.ROCK
                )
            )

        assertEquals(7, score)
    }

    @Test
    fun getTotalScoreOfStrategyGuideWithAssumption() {
        val rps = RockPaperScissors()
        val parsedStrategies = rps.parseToStrategyElement("src/test/resources/realInputs/realinput2_1.txt")

        var totalScore = 0
        for (strategy in parsedStrategies) {
            totalScore += rps.getScoreRegardingAssumption(strategy)
        }
        assertEquals(11767, totalScore)
    }

    @Test
    fun withRealRulesAnXIsLosing() {
        val rps = RockPaperScissors()

        val score = rps.getScoreRegardingRealRules(RockPaperScissors.Play.ROCK, 'X')

        assertEquals(3, score)
    }

    @Test
    fun withRealRulesAnYIsADraw() {
        val rps = RockPaperScissors()

        val score = rps.getScoreRegardingRealRules(RockPaperScissors.Play.ROCK, 'Y')

        assertEquals(4, score)
    }

    @Test
    fun withRealRulesZIsAWin() {
        val rps = RockPaperScissors()

        val score = rps.getScoreRegardingRealRules(RockPaperScissors.Play.ROCK, 'Z')

        assertEquals(8, score)
    }

    @Test
    fun inputIsParsedForRealRules() {
        val rps = RockPaperScissors()
        val parsedStrategies = rps.parseToRealStrategy("src/test/resources/testInputs/testinput2_1.txt")

        val expectedStrategies = listOf(
            RockPaperScissors.RealStrategy(RockPaperScissors.Play.ROCK, 'X'),
            RockPaperScissors.RealStrategy(RockPaperScissors.Play.PAPER, 'Y'),
            RockPaperScissors.RealStrategy(RockPaperScissors.Play.SCISSORS, 'Z')
        )

        assertEquals(expectedStrategies, parsedStrategies)
    }

    @Test
    fun getTotalScoreOfStrategyGuideWithRealRules() {
        val rps = RockPaperScissors()
        val parsedStrategies = rps.parseToRealStrategy("src/test/resources/realInputs/realinput2_1.txt")

        var totalScore = 0
        for (strategy in parsedStrategies) {
            totalScore += rps.getScoreRegardingRealRules(strategy.input, strategy.response)
        }
        assertEquals(13886, totalScore)
    }

}