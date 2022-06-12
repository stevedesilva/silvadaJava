package strategy.initial;

import strategy.initial.ScoreBoard;

public class SquareBallon extends ScoreBoard {
    @Override
    public Integer calculateScore() {
        return this.score + 40;
    }
}
