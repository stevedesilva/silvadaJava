package commonsense.optimise;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class PlayerMatcherTest {
    @Test
    public void testFindPlayerFromBothSports() {
        List<PlayerMatcher.Player> basketballPlayers = new ArrayList<>();
        basketballPlayers.add(new PlayerMatcher.Player("LeBron", "James", "Lakers"));
        basketballPlayers.add(new PlayerMatcher.Player("Stephen", "Curry", "Warriors"));
        basketballPlayers.add(new PlayerMatcher.Player("Kevin", "Durant", "Nets"));
        basketballPlayers.add(new PlayerMatcher.Player("Kyrie", "Irving", "Celtics"));
        basketballPlayers.add(new PlayerMatcher.Player("Steve", "DeSilva", "Celtics"));
        basketballPlayers.add(new PlayerMatcher.Player("Clive", "DeSilva", "Celtics"));
        basketballPlayers.add(new PlayerMatcher.Player("Ben", "DeSilva", "Celtics"));


        List<PlayerMatcher.Player> footballPlayers = new ArrayList<>();
        footballPlayers.add(new PlayerMatcher.Player("Tom", "Brady", "Buccaneers"));
        footballPlayers.add(new PlayerMatcher.Player("Patrick", "Mahomes", "Chiefs"));
        footballPlayers.add(new PlayerMatcher.Player("Aaron", "Rodgers", "Packers"));
        footballPlayers.add(new PlayerMatcher.Player("Drew", "Brees", "Saints"));
        footballPlayers.add(new PlayerMatcher.Player("Ben", "DeSilva", "Celtics"));
        footballPlayers.add(new PlayerMatcher.Player("Steve", "DeSilva", "Celtics"));
        footballPlayers.add(new PlayerMatcher.Player("Clive", "DeSilva", "Celtics"));
        List<String> expectedPlayers = new ArrayList<>();
        expectedPlayers.add("Steve DeSilva");
        expectedPlayers.add("Clive DeSilva");
        expectedPlayers.add("Ben DeSilva");

        final List<String> players = PlayerMatcher.findPlayer(basketballPlayers, footballPlayers);

        // assert
        MatcherAssert.assertThat(players, Matchers.containsInAnyOrder(expectedPlayers.toArray()));
    }
}