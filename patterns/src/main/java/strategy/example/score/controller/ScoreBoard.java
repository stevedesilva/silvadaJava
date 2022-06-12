package strategy.example.score.controller;

public class ScoreBoard {
    public ScoreAlgorithmBase algorithmBase;
    public int showScore(int taps, int multiplier) {
        final int score = algorithmBase.calculateScore(taps, multiplier);
        System.out.println(score);
        return score;
    }
}
