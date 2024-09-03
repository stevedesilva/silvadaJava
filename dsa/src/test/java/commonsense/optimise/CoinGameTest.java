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
    void testPlay() {
        // Test when "me" should win
        assertEquals(CoinGame.ME, coinGame.play(1, CoinGame.ME));
        assertEquals(CoinGame.ME, coinGame.play(2, CoinGame.ME));
        assertEquals(CoinGame.ME, coinGame.play(3, CoinGame.ME));

        // Test when "them" should win
        assertEquals(CoinGame.THEM, coinGame.play(4, CoinGame.ME));
    }
}