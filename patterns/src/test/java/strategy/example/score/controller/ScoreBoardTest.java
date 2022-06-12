package strategy.example.score.controller;

import org.junit.jupiter.api.Test;
import strategy.example.score.model.Ballon;
import strategy.example.score.model.Clown;
import strategy.example.score.model.SquareBallon;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {
    @Test
    public void shouldCalculateScoreWithBallonBaseAlgorithm() {
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.algorithmBase = new Ballon();
        assertEquals(40, scoreBoard.showScore(5, 2));
    }

    @Test
    public void shouldCalculateScoreWithSquareBallonBaseAlgorithm() {
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.algorithmBase = new SquareBallon();
        assertEquals(50, scoreBoard.showScore(5, 2));
    }

    @Test
    public void shouldCalculateScoreWithClownBallonBaseAlgorithm() {
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.algorithmBase = new Clown();
        assertEquals(20, scoreBoard.showScore(5, 2));
    }
}