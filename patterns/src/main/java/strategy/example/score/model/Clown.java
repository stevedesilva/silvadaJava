package strategy.example.score.model;

import strategy.example.score.controller.ScoreAlgorithmBase;

public class Clown extends ScoreAlgorithmBase {
    @Override
    public int calculateScore(int taps, int multiplier) {
        return (taps * multiplier) + 10;
    }
}