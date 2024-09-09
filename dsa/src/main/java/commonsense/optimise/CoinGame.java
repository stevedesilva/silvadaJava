package commonsense.optimise;

public class CoinGame {

    public static final String ME = "me";
    public static final String THEM = "them";


    public String play(int coins, String current) {
        if (coins <= 0) {
            return current;
        }
        if (current.equalsIgnoreCase(ME)) {
            current = THEM;
        } else {
            current = ME;
        }

        if (play(coins - 1, current).equalsIgnoreCase(ME) || play(coins - 2, current).equalsIgnoreCase(ME) ) {
            return ME;
        } else {
            return THEM;
        }
    }


}
