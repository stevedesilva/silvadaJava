package commonsense.optimise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        final int i = (coins - 1) % 3;
        if (i == 0) {
            //   THEM
            return  currentPlayer.equalsIgnoreCase(YOU) ? THEM : YOU;
        } else {
            //    YOU
            return currentPlayer.equalsIgnoreCase(YOU) ? YOU : THEM;
        }
    }

    public boolean validate(String player) {
        final Pattern compile = Pattern.compile("^(you|them)$");
        final Matcher matcher = compile.matcher(player);
        return matcher.find();
    }

}
