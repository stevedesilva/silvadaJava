package commonsense.optimise;

public class CoinGame {

    public static final String YOU = "you";
    public static final String THEM = "them";


    public String playOriginal(int coins, String currentPlayer) {
        if (coins <= 0) {
            return currentPlayer;
        }
        String nextPlayer;
        if (currentPlayer.equalsIgnoreCase(YOU)) {
            nextPlayer = THEM;
        } else {
            nextPlayer = YOU;
        }

        if (play(coins - 1, nextPlayer).equalsIgnoreCase(currentPlayer) ||
                play(coins - 2, nextPlayer).equalsIgnoreCase(currentPlayer) ) {
            return currentPlayer;
        } else {
            return nextPlayer;
        }
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
    public String play(int coins, String currentPlayer) {
        // mod 3
        final int i = coins % 3;
        if (i == 0) {
            return currentPlayer;
        } else {
            return currentPlayer.equalsIgnoreCase(YOU) ? THEM : YOU;
        }
    }

}
