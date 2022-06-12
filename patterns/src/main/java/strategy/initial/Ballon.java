package strategy.initial;

public class Ballon extends ScoreBoard {
    @Override
    public Integer calculateScore() {
        return this.score + 30;
    }
}
