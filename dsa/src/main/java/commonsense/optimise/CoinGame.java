package commonsense.optimise;

public class CoinGame {

    public static final String YOU = "you";
    public static final String THEM = "them";


    public String play(int coins, String currentPlayer) {
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

}
