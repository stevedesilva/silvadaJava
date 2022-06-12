package strategy.initial;

public abstract class ScoreBoard {
    protected Integer score;
    public abstract Integer calculateScore();

    public void showScore() {
        System.out.println("Score is "+ score);
    }
}
