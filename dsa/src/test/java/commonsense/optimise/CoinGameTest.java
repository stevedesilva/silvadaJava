package commonsense.optimise;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertEquals(CoinGame.THEM, coinGame.play(1, CoinGame.YOU));
        assertEquals(CoinGame.YOU, coinGame.play(1, CoinGame.THEM));
    }

    @Test
    public void testPlayTwoCoin() {
        // Test when "me" should win
        assertEquals(CoinGame.YOU, coinGame.play(2, CoinGame.YOU));
        assertEquals(CoinGame.THEM, coinGame.play(2, CoinGame.THEM));
    }

    @Test
    public void testPlayThree() {
        // Test when "me" should win
        assertEquals(CoinGame.YOU, coinGame.play(3, CoinGame.YOU));
        assertEquals(CoinGame.THEM, coinGame.play(3, CoinGame.THEM));
    }

    @Test
    public void testPlayFour() {
        // Test when "me" should win
        assertEquals(CoinGame.THEM, coinGame.play(4, CoinGame.YOU));
        assertEquals(CoinGame.YOU, coinGame.play(4, CoinGame.THEM));
    }

    @Test
    public void testPlayFive() {
        // Test when "me" should win
        assertEquals(CoinGame.YOU, coinGame.play(5, CoinGame.YOU));
        assertEquals(CoinGame.THEM, coinGame.play(5, CoinGame.THEM));
    }

    @Test
    public void testPlaySix() {
        // Test when "me" should win
        assertEquals(CoinGame.YOU, coinGame.play(6, CoinGame.YOU));
        assertEquals(CoinGame.THEM, coinGame.play(6, CoinGame.THEM));
    }

    @Test
    public void shouldThrowExceptionForInvalidPlayer(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            coinGame.play(6, "wrong");
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"you,true","them,true","oooyouuuu,false","other,false","You,false","Them,false"}, delimiter = ',')
    public void testIsValidPlayer(String word, boolean expected) {
        MatcherAssert.assertThat(coinGame.validate(word), Matchers.equalTo(expected));
    }
}