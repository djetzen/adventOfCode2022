package de.djetzen.advent

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class RockPaperScissorsTest {

    @Test
    fun inputIsParsedAppropriate() {
        val rps = RockPaperScissors()
        val parsedStrategies = rps.parse("src/test/resources/testinputs/testinput2_1.txt")

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
            rps.getScore(RockPaperScissors.StrategyElement(RockPaperScissors.Play.ROCK, RockPaperScissors.Play.ROCK))

        assertEquals(4, score)
    }

    @Test
    fun playingPaperIsScoreTwo() {
        val rps = RockPaperScissors()

        val score =
            rps.getScore(RockPaperScissors.StrategyElement(RockPaperScissors.Play.PAPER, RockPaperScissors.Play.PAPER))

        assertEquals(5, score)
    }

    @Test
    fun playingScissorsIsScoreThree() {
        val rps = RockPaperScissors()

        val score =
            rps.getScore(
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
            rps.getScore(RockPaperScissors.StrategyElement(RockPaperScissors.Play.PAPER, RockPaperScissors.Play.ROCK))

        assertEquals(1, score)
    }

    @Test
    fun drawIsScoreOfThreePlusPlayed() {
        val rps = RockPaperScissors()

        val score =
            rps.getScore(RockPaperScissors.StrategyElement(RockPaperScissors.Play.ROCK, RockPaperScissors.Play.ROCK))

        assertEquals(4, score)
    }


    @Test
    fun scissorWinsAgainstPaper() {
        val rps = RockPaperScissors()

        val score =
            rps.getScore(
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
            rps.getScore(
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
            rps.getScore(
                RockPaperScissors.StrategyElement(
                    RockPaperScissors.Play.SCISSORS,
                    RockPaperScissors.Play.ROCK
                )
            )

        assertEquals(7, score)
    }

    @Test
    fun getTotalScoreOfStrategyGuide() {
        val rps = RockPaperScissors()
        var parsedStrategies = rps.parse("src/test/resources/realinputs/realinput2_1.txt")

        var totalScore = 0
        for (strategy in parsedStrategies) {
            totalScore += rps.getScore(strategy)
        }
        assertEquals(11767, totalScore)
    }


}