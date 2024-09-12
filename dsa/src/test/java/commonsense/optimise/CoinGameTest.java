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

    /*
        Player turn ME
        Number of coins = 1 Winner = THEM
        Number of coins = 2 Winner = ME
        Number of coins = 3 Winner = ME
        Number of coins = 4 Winner = THEM
        Number of coins = 5 Winner = ME
        Number of coins = 6 Winner = ME
        Number of coins = 7 Winner = THEM
        Number of coins = 8 Winner = ME
        Number of coins = 9 Winner = ME
        Number of coins = 10 Winner = THEM
     */
    @Test
    public void testPlayOneCoin() {
        // Test when "me" should win
        assertEquals(CoinGame.THEM, coinGame.play(1, CoinGame.ME));
    }

    @Test
    public void testPlayTwoCoin() {
        // Test when "me" should win
        assertEquals(CoinGame.ME, coinGame.play(2, CoinGame.ME));
    }

    @Test
    public void testPlayThree() {
        // Test when "me" should win
        assertEquals(CoinGame.ME, coinGame.play(3, CoinGame.ME));
    }

    @Test
    public void testPlayFour() {
        // Test when "me" should win
        assertEquals(CoinGame.THEM, coinGame.play(4, CoinGame.ME));
    }

}