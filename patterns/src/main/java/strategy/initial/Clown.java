package strategy.initial;

public class Clown extends ScoreBoard {
    @Override
    public Integer calculateScore() {
        return this.score + 10;
    }
}
