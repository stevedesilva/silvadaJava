package commonsense.optimise;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerMatcherTest {
    @Test
    public void testFindPlayerFromBothSports() {
        PlayerMatcher playerMatcher = new PlayerMatcher();
        List<PlayerMatcher.Player> basketballPlayers = new ArrayList<>();
        basketballPlayers.add(new PlayerMatcher.Player("LeBron", "James", "Lakers"));
        basketballPlayers.add(new PlayerMatcher.Player("Stephen", "Curry", "Warriors"));
        basketballPlayers.add(new PlayerMatcher.Player("Kevin", "Durant", "Nets"));
        basketballPlayers.add(new PlayerMatcher.Player("Kyrie", "Irving", "Celtics"));


        List<PlayerMatcher.Player> footballPlayers = new ArrayList<>();
        footballPlayers.add(new PlayerMatcher.Player("Tom", "Brady", "Buccaneers"));
        footballPlayers.add(new PlayerMatcher.Player("Patrick", "Mahomes", "Chiefs"));
        footballPlayers.add(new PlayerMatcher.Player("Aaron", "Rodgers", "Packers"));
        footballPlayers.add(new PlayerMatcher.Player("Drew", "Brees", "Saints"));
        List<String> expectedPlayers = new ArrayList<>();
        expectedPlayers.add("LeBron James (Lakers)");

        final List<String> player = playerMatcher.findPlayer(basketballPlayers, footballPlayers);


    }
}