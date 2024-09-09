package commonsense.optimise;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoinGameTest {
    private CoinGame coinGame;

    @BeforeEach
    void setUp() {
        coinGame = new CoinGame();
    }

    @Test
    public void testPlayOneCoin() {
        // Test when "me" should win
        assertEquals(CoinGame.THEM, coinGame.play(1, CoinGame.ME));
        assertEquals(CoinGame.ME, coinGame.play(1, CoinGame.THEM));
    }

    @Test
    public void testPlayTwoCoin() {
        // Test when "me" should win
        assertEquals(CoinGame.ME, coinGame.play(2, CoinGame.ME));
        assertEquals(CoinGame.THEM, coinGame.play(2, CoinGame.THEM));
    }
}